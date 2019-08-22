import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        int i=0;
        // int first_index=0;
        // int sec_index=0;
        // int[] singleArray=new int[2];
        //     singleArray[0]=newInterval[0];
        //     singleArray[1]=newInterval[1];
        List<int[]> lists=new ArrayList<>();
        while(i<intervals.length){
            if (newInterval[1]>=intervals[i][0]){     //new数组中大的数要不小于数组中第一个数
                if(newInterval[0]<=intervals[i][1]){       //第一个数小于数列中第二个数
                    if(newInterval[0]>intervals[i][0]) {  //判定singlearray的第一个数是什么min
                        // first_index=i;
                        newInterval[0]=intervals[i][0];
                    }
                    if(newInterval[1]<=intervals[i][1]){ //第二个数小于数组第二个数，newinterval的max数变成数组的第二个数
                        // sec_index=i;
                        newInterval[1]=intervals[i][1];

                    }
                }else{

                    lists.add(intervals[i]);
                }
            }else{
                lists.add(newInterval);
                lists.add(intervals[i]);
                break;
            }

            i++;
        }
        if(!lists.contains(newInterval)){
            lists.add(newInterval);
        }
        while(++i<intervals.length){
            lists.add(intervals[i]);
        }
        int[][] int_lists=new int[lists.size()][2];

//        最后放弃了不用lists的方法，发现原来写的方法其实很快，99%，只是因为添加了system.OUT
                //下面的代码是关于使用静态数组的尝试
//        int[][] int_lists;
//        if(sec_index-first_index!=0) {
//          int_lists = new int[lists.size() - first_index + sec_index - 1][2];
//            for (i = 0; i < first_index; i++) {
//                int_lists[i] = intervals[i];
//            }
//            int_lists[first_index] = newInterval;
//            for (i = first_index + 1; i < int_lists.length; i++) {
//                int_lists[i] = intervals[i + sec_index - first_index];
//            }
//        }else{
//            boolean tf=false;
//            int j=0;             //用来表示intervals的数组数据，因为可能存在越界
//           int_lists = new int[intervals.length+1][2];
//           for(i=0;i<int_lists.length;i++){
//               if(!tf){
//                   j=i;
//               }else{
//                   j=i-1;
//               }
//               if(newInterval[1]<intervals[j][0]&&!tf){
//                        int_lists[i]=newInterval;
//                        tf=true;
//               }else{
//                   int_lists[i]=intervals[j];
//               }
//           }
//           if(i==j){          //如果数字到最后都是相等，说明newInterval是最大的，没有被插入;
//               int_lists[i+1]=newInterval;
//           }
//        }
        for(i=0;i<lists.size();i++){
            int_lists[i][0]=lists.get(i)[0];
            int_lists[i][1]=lists.get(i)[1];
        }
        return int_lists;
    }
}
