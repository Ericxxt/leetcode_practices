import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer,Integer> map=new HashMap<>();
            return recur(nums,0,S,new HashMap<>());
    }
    public int recur(int[] nums,int index,int S,Map<Integer,Integer> map){
        if(map.containsKey(S)) return map.get(S);
        if(index==nums.length-1 ){
            int count=0;
            count=nums[index]==S?++count:count;
            count=nums[index]==-S?++count:count;
            map.put(S,count);
            return count;
        }
        return recur(nums,index+1,S-nums[index],map)+recur(nums,index+1,S+nums[index],map);
    }
}
