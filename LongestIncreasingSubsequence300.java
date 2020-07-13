import java.util.Stack;

public class LongestIncreasingSubsequence300 {
    //这题感觉想到dp的话就不难，刚开始往单调栈想，但其实不用，感觉还是不够熟练
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2) return nums.length;
        int max_len=1;
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max_len=Math.max(max_len,dp[i]);
        }
        return max_len;
    }
    //下面这种高票方法超屌，叫tail
    //int[] tails =new int[nums.length]
    //tail[i]表示存放长度为i+1的序列的最小tail的最后一个值，也就是尾巴
    //len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    //下面可以看到如果有大于6的那么一定有大于5的，所以tails的值取小的尾巴值
    //len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    //len = 3   :      [4, 5, 6]            => tails[2] = 6
    public int lengthOfLIS(int[] nums) {
        if(nums.length<2) return nums.length;
        int[] tails=new int[nums.length];
        int size=0;
        for(int i=0;i<nums.length;i++){


        }
    }



    //tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    //For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
    //
    //len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    //len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    //len = 3   :      [4, 5, 6]            => tails[2] = 6
    //We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
    //
    //Each time we only do one of the two:
    //
    //(1) if x is larger than all tails, append it, increase the size by 1
    //(2) if tails[i-1] < x <= tails[i], update tails[i]
    //Doing so will maintain the tails invariant. The the final answer is just the size

    //public int lengthOfLIS(int[] nums) {
    //    int[] tails = new int[nums.length];
    //    int size = 0;
    //    for (int x : nums) {
    //        int i = 0, j = size;
    //        while (i != j) {
    //            int m = (i + j) / 2;
    //            if (tails[m] < x)
    //                i = m + 1;
    //            else
    //                j = m;
    //        }
    //        tails[i] = x;
    //        if (i == size) ++size;
    //    }
    //    return size;
    //}
}
