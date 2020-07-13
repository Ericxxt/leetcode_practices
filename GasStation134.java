import java.util.*;

public class GasStation134 {
    //这道题目我感觉自己完全理解错了题目意思，这个station运输，是从i开始路过i+1然后回到i，所以是顺序的
    //只要保证gas的值大于总的cost就可以保证题目有解
    //只要碰到第一个可行的点那么这个点就是唯一的解决办法
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int start_node=0;
        int unchanged_sum=0;
         for(int i=0;i<gas.length;i++){
             //需要这个值判断这个问题有没有解
             unchanged_sum+=gas[i]-cost[i];
             //sum是一个累加的过程，但是前面如果都是负的不能判断后面这个i+1的解能不能成立
             sum+=gas[i]-cost[i];
             if(sum<0){
                 start_node=i+1;
                 //sum需要归0
                 sum=0;
             }
         }
        if(unchanged_sum<0){
            return -1;
        }else{
            return start_node;
        }
    }
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        List<Integer> list=new ArrayList<>();
//        recursion_find(gas,cost,-1,0,list);
//        return start_gas;
//    }
//    int start_gas=-1;
//    public void recursion_find(int[] gas,int[]  cost,int last_station,int cur_gas,List<Integer> list){
//        if(start_gas!=-1){
//            return;
//        }
//        if(last_station!=-1) {
//            cur_gas -=cost[last_station];
//        }
//        if(list.size()==gas.length){
//            if(cur_gas>=cost[last_station]){
//                start_gas=list.get(0);
//            }
//        }
//        for(int i=0;i<gas.length;i++){
//            if(list.contains(gas[i])){
//                continue;
//            }
//            if(cur_gas+gas[i]>=cost[i]){
//                cur_gas+=gas[i];
//                list.add(i);
//                recursion_find(gas,cost,i,cur_gas,list);
//                if(start_gas!=-1){
//                    return;
//                }else{
//                    list.remove(list.size()-1);
//                }
//            }
//        }
//        return;
//    }
}
