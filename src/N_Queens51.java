import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_Queens51 {
    //2019.10.06 写了好久，总算运行出来了，最后还是有点问题
//      ZQZZZ
//      ZZZQZ
//      QZZZZ
//      ZZZZQ
//      ZZQZZ




    //2019.10.07凌晨，终于搞定了，全程自己写
    //Runtime: 8 ms, faster than 13.77% of Java online submissions for N-Queens.
    //Memory Usage: 39.8 MB, less than 13.51% of Java online submissions for N-Queens.
    public class point{
        int x,y;
        point(int out_x,int out_y){
            x=out_x;
            y=out_y;
        }
    }
    //还是没有完全解决对角线问题
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists=new LinkedList<>();
        List<String> single_list=new LinkedList<>();
        List<Integer> cannot_num=new ArrayList<>();
        List<point> points=new ArrayList<>();
        list_recursion(lists,single_list,0,n,cannot_num,points);
        return lists;
    }
    public void list_recursion(List<List<String>> lists, List<String> single_list, int index_col, int n, List<Integer> cannot_num,List<point> points){
        if(index_col==n){
            lists.add(new LinkedList<>(single_list));
            return;
        }
        for(int i=0;i<n;i++){//如果符合就生成
            if(num_valid(cannot_num,i,n,index_col,points)){//去除针对上次不行的，生成对这次不行的
//                System.out.println("first:index:"+index_col+",list:"+single_list.toString()+"，cannot"+cannot_num.toString());
                single_list.add(generate_list(i,n));

                while(cannot_num.size()!=index_col){
                    cannot_num.remove(cannot_num.size()-1);
                }
                cannot_num.add(i);
                points.add(new point(i,index_col));
                 add_cannot(i,n,cannot_num);
//                System.out.println("sec:index:"+index_col+",list:"+single_list.toString()+"，cannot"+cannot_num.toString());
                list_recursion(lists,single_list,index_col+1,n,cannot_num,points);
//                recursion_remove(index_col,i,cannot_num,two_num_or);
                while(cannot_num.size()!=index_col){
                    cannot_num.remove(cannot_num.size()-1);
                }
               if(cannot_num.size()!=0){
                   int last_num=cannot_num.get(cannot_num.size()-1);
               add_cannot(last_num,n,cannot_num);
               }
                if(single_list.size()!=index_col){
                    single_list.remove(single_list.size()-1);
                }
                points.remove(points.size()-1);
            }
        }
        return;
    }

    public void add_cannot(int num,int n,List<Integer> cannot_num){
        if (num == 0) {
            cannot_num.add(1);
        } else if (num == n - 1) {
            cannot_num.add(n - 2);
        } else {
            cannot_num.add(num - 1);
            cannot_num.add(num + 1);
        }
    }
    public boolean num_valid(List<Integer> cannot_num,int i,int n,int index_col,List<point> points){//验证数字是否可以
        for(int num2: cannot_num){
            if(i==num2){
                return false;
            }
        }
        for(point single_point :points){
           if(Math.abs(single_point.x-i)==Math.abs(single_point.y-index_col)){
               return false;
           }
        }

        return true;
    }
    public String generate_list(int index,int n){//生成单个string
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==index){
                sb.append("Q");
            }else{
                sb.append(".");
            }
        }
        return sb.toString();
    }


    //    //一个数组用来标记对角线的列号
//    public static void add_diagonal(int i,int index_col,int n,List<Integer> diagonal,boolean right){
//        int range_num=right?Math.min(n-i-1,n-index_col-1):Math.min(i+1,n-index_col-1);
//        for(int index=1;index<=range_num;index++){
//            diagonal.add(i+index);
//        }
//    }
    //    public static void cannot_remove(int index_col,int i,int n,List<Integer> cannot_num,boolean two_num_or){
//        if(index_col!=0){
//            if(i!=0) {
//                if (two_num_or) {//表示上次的数字不是边界，限制的是两边
//                    cannot_num.remove(cannot_num.size() - 1);
//                    cannot_num. remove(cannot_num.size() - 1);
//                } else {
//                    cannot_num.remove(cannot_num.size() - 1);
//                }
//            }
//        }
//    }
//    public static void recursion_remove(int index_col,int i,List<Integer> cannot_num,boolean two_num_or){
//        if(index_col!=0){
//            if(i!=0) {
//                if (two_num_or) {//表示上次的数字不是边界，限制的是两边
//                    cannot_num.remove(cannot_num.size() - 1);
//                    cannot_num. remove(cannot_num.size() - 1);
//                    cannot_num. remove(cannot_num.size() - 1);
//                } else {
//                    cannot_num.remove(cannot_num.size() - 1);
//                    cannot_num. remove(cannot_num.size() - 1);
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(5).toString());
    }
}
