public class HouseRobber198 {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length+1][2];
        //dp[i][0]表示这次没抢，dp[i][1]表示这次抢了
        //在想这道问题的时候我总是纠结相隔两个元素的最优应该如何解决
        //比如7，2，2，8， 应该取7，8 最优
        //如果dp长度不是length+1，那么dp[0][0]无法从前一项判断
        //相当于假设数组开头还有个0
        for(int i=1;i<=nums.length;i++){
            //dp[i][0]表示不抢，所以取之前的最优值,其实也就是上一步的抢，所以才会有更简化的算法
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            //dp[i][1]表示抢，所以前一晚肯定不能抢，所以需要取前晚没抢的最优值
            dp[i][1]=dp[i-1][0]+nums[i-1];
        }
        return Math.max(dp[nums.length+1][0],dp[nums.length+1][1]);
    }
    //以下是简便算法，主要是因为数组中的很多元素也没啥用
    //public int rob(int[] num) {
    //    int prevNo = 0;
    //    int prevYes = 0;
    //    for (int n : num) {
    //        int temp = prevNo;
    //        prevNo = Math.max(prevNo, prevYes);
    //        prevYes = n + temp;
    //    }
    //    return Math.max(prevNo, prevYes);
    //}
}
