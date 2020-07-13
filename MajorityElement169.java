import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    // Moore voting algorithm 感觉这个算法需要好好理解
    //如果遇到相同的比较元素，那么count会++，如果遇到不同的，会削弱当前的count，到最后一定是count最多的元素胜出
    public int majorityElement03(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }
    //自己根据上面的高票算法理解了一下又写了一遍
    public int majorityElement02(int[] nums) {
        int count=0;
        int king_num=0;
        for(int i : nums){
            if(count==0){
                king_num=i;
            }
            if(king_num==i){
                count++;
            }else{
                count--;
            }
        }
        return king_num;
    }
    //下面是自己的方法
    public int majorityElement01(int[] nums) {
        int num=nums.length/2;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if (map.containsKey(i)){
                if(map.get(Integer.valueOf(i))==num) return i;
                map.put(i,map.get(Integer.valueOf(i))+1);
            }else{
                map.put(i,1);
            }
        }
        return nums[0];
    }
}
