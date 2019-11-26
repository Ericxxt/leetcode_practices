import java.util.List;

public class Triangle120 {
    //[
    //     [2],
    //    [3,4],
    //   [6,5,7],
    //  [4,1,8,3]
    //]

    //Runtime: 2 ms, faster than 84.51% of Java online submissions for Triangle.
    //Memory Usage: 37.5 MB, less than 87.76% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle.size()==0){
//            return 0;
//        }
//        if(triangle.size()==1){
//            return triangle.get(0).get(0);
//        }
        int[] trgle_array=new int[triangle.size()+1];
        //思路就是只有相同size的[]，从最底层往上输出，最后一个也就是第一个就是答案
        for(int i=triangle.size();i>0;i--){
            for(int j=0;j<i;j++){
                //int[] trgle_array=new int[triangle.size()+1];设置成triangle.size()+1之后就不需要if else区分了
//                if(i==triangle.size()-1){
//                    trgle_array[j]=triangle.get(i-1).get(j);
//                }else {
                    trgle_array[j] = Math.min(trgle_array[j], trgle_array[j + 1]) + triangle.get(i - 1).get(j);
            }
//            System.out.print("**********");
//            for(int num:trgle_array){
//                System.out.print(num+",");
//            }
//            System.out.print("**********");
        }
        return trgle_array[0];
    }
    //下面的方法　time exceeded
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int len=0;
//        recur_cal(triangle,0,1,triangle.get(0).get(0));
//        return min_value;
//    }
//    int min_value=Integer.MAX_VALUE;
//    public void recur_cal(List<List<Integer>> triangle,int index,int level,int cur_value){
//        if(cur_value>=min_value){
//            return;
//        }
//        if(level==triangle.size()){
//            min_value=Math.min(min_value,cur_value);
//            return;
//        }
//        cur_value+=triangle.get(level).get(index);
//        recur_cal(triangle,index,level+1,cur_value);
//        cur_value-=triangle.get(level).get(index);
//        cur_value+=triangle.get(level).get(index+1);
//        recur_cal(triangle, index+1, level+1, cur_value);
//        return;
//    }
}
