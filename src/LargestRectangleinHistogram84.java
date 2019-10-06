import java.util.Stack;

public class LargestRectangleinHistogram84 {
 //目前的way1还有way2都是O(N2)方法，
    // way1 no max value
//    public int largestRectangleArea(int[] heights) {
//        if (heights.length==0){
//            return 0;
//        }
//        if(heights.length==1){
//            return heights[0];
//        }
//        // int max=0;
//        int present_max=heights[0];
//        int present_height=0;
//        for(int i=0;i<heights.length;i++){
//            if(heights[i]==0){
//                continue;
//            }else {
//                // present_max=heights[i];
//
//                present_height=heights[i];
//                present_max = Math.max(present_max,heights[i]);
//                for (int j = i + 1; j < heights.length; j++) {
//                    present_height=Math.min(present_height,heights[j]);
//                    if(heights[j]==0){
//                        break;//go to head 'for' loop
//                    }else {
//                        //present_max/(j-i) =present_height这个公式是错的，因为不一定最大的是当前j的上一个也可能是刚开始的
//
//                        present_max = Math.max(present_max,present_height*(j-i+1));
//                    }
//                }
//                // max=Math.max(max,present_max);
//            }
//        }
//        if(heights[heights.length-1]!=0&&heights[heights.length-2]==0){
//            return Math.max(heights[heights.length-1],present_max);
//        }
//        return present_max;
//    }

//    //way 2 max value
//    public int largestRectangleArea(int[] heights) {
//        if (heights.length==0){
//            return 0;
//        }
//        int max=0;
//        int present_max=0;
//        int present_height=0;
//        for(int i=0;i<heights.length;i++){
//            if(heights[i]==0){
//                continue;
//            }else {
//                present_max=heights[i];
//                present_height=heights[i];
//                for (int j = i + 1; j < heights.length; j++) {
//                    if(heights[j]==0){
//                        break;//go to head 'for' loop
//                    }else if(heights[j]>present_height){
//                        present_max+=present_height;
//                    }else{
//                        //present_max/(j-1) =present_height
//                        present_height=Math.min(present_height,heights[j]);
//                        present_max = Math.max(present_max,present_height*(j-i+1));
//                    }
//                }
//                max=Math.max(max,present_max);
//            }
//        }
//        return max;
//    }
//    Runtime: 13 ms, faster than 69.90% of Java online submissions for Largest Rectangle in Histogram.
//    Memory Usage: 41.1 MB, less than 70.45% of Java online submissions for Largest Rectangle in Histogram.
    //2019。9。7号，现在打算重写这个方法使用单调栈
public int largestRectangleArea(int[] bars) {
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
}
