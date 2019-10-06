import java.util.Stack;

public class MaximalRectangle85 {
    //2019.09.07打算放弃先前写的代码，因为下面一段实在太过于麻烦，这道题目和84方法十分相似，用的也是单调栈，把之前的代码套过来用即可
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix.length ==0 || matrix[0].length ==0) {
//            return 0;
//        }
//        int max = 0;
//        int count=0;
//        if(matrix.length==1){
//            for(int i=0;i<matrix[0].length;i++){
//                if(matrix[0][i]=='1'){
//                    count++;
//                    max=Math.max(max,count);
//                }else{
//                    count=0;
//                }
//            }
//            return max;
//        }
//        if(matrix[0].length==1){
//            for(int i=0;i<matrix.length;i++){
//                if(matrix[i][0]=='1'){
//                    count++;
//                    max=Math.max(max,count);
//                }else{
//                    count=0;
//                }
//            }
//            return max;
//        }
////        int width=0;
//        int height = 0;
//
//        int start;
//        for (int i = 0; i < matrix.length; i++) {
//            int j = 0;
//            while (j < matrix[0].length) {
//                start = j;
//                if (matrix[i][j] != '1') {//第一个不为1就不需要判断了
//                    j++;
//                } else {
//                    while (j < matrix[0].length && matrix[i][j] == '1') {
//                        j++;  //因为是先j++再判断，所以最后j的值可能会等于matrix[0].length
//                    }
//                    j--;
//                    if(j==start){
//                        max=max>1?max:1;
//                    }
//                    max=Math.max(max,find_max(i,height,matrix,j,start,max));
//
//                    //下面一段注释了因为长度为1好像也可以
////                    if (j == start) {//长度不足为2
////
////                    }else{
//
//                    j = start + 1;
//                }//else matrix[i][start]!='1'
//
//            }
//        }
//        return max;
//    }
//    public int find_max(int i,int height,char[][] matrix,int j,int start,int max){
//        while(j>start) {
//            if((j - start + 1) * (matrix.length - i + 1)<max){
//
//                return max;
//            }
//            height = i + 1;
//            while (height < matrix.length) {
//                int x_index = start;
//                while (x_index <= j) {
//                    if (matrix[height][x_index] == '1') {
//                        x_index++;
//                    } else {
//                        break;
//                    }
//                }
//                x_index--;
//                if (x_index == j) {
//                    height++;
//                } else {
//                    height--;
//                    break;
//                }
//            }
//            if (height == matrix.length) {
//                height = matrix.length - 1;
//            }
//            max = Math.max(max, (j - start + 1) * (height - i + 1));
//            // System.out.println("max:"+max);
//            j--;
//        }
//        return max;
//    }
    //2019。09。07
//    Runtime: 31 ms, faster than 13.78% of Java online submissions for Maximal Rectangle.
//    Memory Usage: 43.9 MB, less than 63.04% of Java online submissions for Maximal Rectangle.
    //下面这里使用单调栈
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=0;
        int[] bars=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]=='1'){
                    bars[j]++;
                }else{

                    bars[j]=0;
                }
            }
            max=Math.max(max,max_area84(bars));
        }
        return max;
    }
    public static int max_area84(int[] bars) {
        if(bars.length==0){
            return 0;
        }
        int max=0;
        int left_most;
        int current;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<bars.length;i++) {
            //下面的stack.peek()<bars[i]如果使用的不是小于等于的话，那么只要pop一下之后的peek就是左边界
            if (stack.isEmpty() || bars[stack.peek()] <= bars[i]) {
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&bars[stack.peek()]>bars[i]) {
                    current=stack.pop();
                    left_most=stack.isEmpty()?-1:stack.peek();
                    max = Math.max(max,bars[current] * (i - left_most-1));
                }
                //i--这个做法真的好聪明，也就是下一步的i还是这个值，就可以继续判断栈里面是否有比i大的元素
                i--;
            }


        }
        int right_most=stack.peek()+1;

        while (!stack.isEmpty()){
            current=stack.pop();
            left_most=stack.isEmpty()?-1:stack.peek();
            max = Math.max(max,bars[current] * (right_most - left_most-1));
        }
        return max;
    }
    public static void main(String[] args) {
        char[][] chars=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(chars));
    }
}
