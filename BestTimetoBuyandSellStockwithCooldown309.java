public class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
            //buy keep sell cooldown
            // the last day, who bought has to sell all out
        // dp[i][0] 表示买，dp[i][1]表示卖
        if(prices.length<2) return 0;
            int[][] dp=new int[prices.length+1][2];
            dp[1][0]=-prices[0];
            //下面这部表示sell但是一开始不能sell
            dp[1][1]=0;
            //这题真的想了很久很久想到夜里
            //纠结于为什么sell也就是dp[i][1]总能取到最优值
            //buy[i]也就是dp[i][0]表示表示的是昨天买和今天买能得到的最优值
            //如果今天买比昨天买贵那么说明性价比低，不如昨天买
            //sell[i]表示昨天的最优值和资产-昨天买时的最优值+今天的股价
            for(int i=1;i<prices.length;i++){
                //buy当前的最大值是两天前的最大值或者是几天前的最大值
                //要注意不管怎么样，当天的资产是一定会用来买的
                //buy的最优值可以看作是
                // sell[i-1]-buy[i]和sell[i-2]-buy[i-1]的比较
                //所以今天买不买的最优值取决于继续持股还是前天卖了再买
                dp[i+1][0]=Math.max(dp[i][0],dp[i-1][1]-prices[i]);
                //下面为什么是加法，因为dp[i][0]在当初购买的时候已经亏损掉钱了
                //买入的时候只要直接加上prices就可以
                dp[i+1][1]=Math.max(dp[i][1],dp[i][0]+prices[i]);
            }
            return dp[prices.length][1];
    }
}
