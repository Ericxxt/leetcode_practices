import java.util.Arrays;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2!=0) return false;
        sum/=2;
        boolean[] dp=new boolean[sum+1];
//        不要忘记设置dp[0]=true
        dp[0]=true;
//        for(int i:nums){
//            //下面j>=nums[i]，保证dp[nums[i]]=true;
//            for(int j=sum;j>=i;j--){
//                dp[j]=dp[j]||dp[j-i];
//            }
//            //加上下面这句快很多
//            if(dp[sum]==true) return true;
//        }
        //改写上面的方法
        //下面这种很快
        //Runtime: 4 ms, faster than 85.92% of Java online submissions for Partition Equal Subset Sum.
        //Memory Usage: 38.4 MB, less than 38.10% of Java online submissions for Partition Equal Subset Sum.
        int start_border=0;
        int current=0;
        for(int i:nums){
            //下面j>=nums[i]，保证dp[nums[i]]=true;
            //下面确定第二层循环的起始数
            start_border=Math.min(current+i,sum);
            for(int j=start_border;j>=i;j--){
                dp[j]=dp[j]||dp[j-i];
            }
            //加上下面这句快很多
            if(dp[sum]==true) return true;
            current+=i;
        }
        // foreach (int x in nums)
        //        {
        //            int max = Math.Min(currSum + x, target);
        //            for (int j = max; j >= x; j--)
        //            {
        //                dp[j] = dp[j] || dp[j-x];
        //            }
        //
        //            if (dp[target] == true) return true;
        //            currSum += x;
        //        }
        return dp[sum];
    }
//    public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int i:nums) sum+=i;
//        if(sum%2!=0) return false;
//        sum/=2;
//        boolean[] dp=new boolean[sum+1];
////        不要忘记设置dp[0]=true
//        dp[0]=true;
//        Arrays.sort(nums);
//        int current=0;
//        for(int i:nums){
//            for(int border=Math.min(current+i,sum);border>=i;border--){
//
//            }
//
//
//        }
//    }
}
