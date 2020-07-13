import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    //高票方法
    //基于dp[i,j]=dp[0,j]-dp[0,i-1]
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            //思考下下面为什么是sum而不是num
            //因为dp[i,j]=dp[0,j]-dp[0,i-1]，dp[0,i-1]对应的就是0-j的sum
//            dp[0,j]-dp[i,j]=sum-k
            //sum即使相同，但是可能位置不同，所以对应的value需要+1
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    //下面这种太慢了
    public int subarraySum(int[] nums, int k) {
        int left,right;
        left=0;
        int sum=0;
        int count=0;
        while (left<nums.length){
            right=left;
            while (right<nums.length){
                sum+=nums[right];
                if(sum==k) count++;
                right++;
            }
            sum-=nums[left];
            left++;
        }
        return count;
    }
    //dp
//    public int subarraySum(int[] nums, int k) {
//        int[][] dp=new int[nums.length+1][nums.length+1];
//        int count=0;
//        for(int i=1;i<=nums.length;i++){
//            dp[1][i]=dp[1][i-1]+nums[i-1];
//            if(dp[1][i]==k) count++;
//        }
//        for(int i=2;i<=nums.length;i++){
//            for(int j=2;j<=i;j++){
//                dp[j][i]=dp[1][i]-dp[1][j-1];
//                if(dp[j][i]==k) count++;
//            }
//        }
//        return count;
//    }
}
