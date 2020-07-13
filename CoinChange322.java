import java.util.Arrays;

public class CoinChange322 {
    //用dp方法做
    //下面这个方法真的很巧妙，将整个amount作为dp数组的长度
    //Runtime: 19 ms, faster than 34.16% of Java online submissions for Coin Change.
    //Memory Usage: 41 MB, less than 5.33% of Java online submissions for Coin Change.
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        int min;
        for(int i=1;i<=amount;i++){
            min=Integer.MAX_VALUE;
            for(int num:coins){
                //dp[0]的时候正好是每个dp[coin]被赋值的时候
                if(i-num>=0&&coins[i-num]!=-1){
                    min=dp[i-num]<min?dp[i-num]+1:min;
                }
            }
            dp[i]=min==Integer.MAX_VALUE?-1:min;
        }
        return dp[amount];
    }
    //下面这种算法感觉实际不可行，因为每次都是把一个数求到极限不能再多了才换下一个数，
    // 但实际上很可能达到amount的时候coin各数的times是均衡的
    //因为是coin，所以coins的值一定为正,然后amount肯定大于0
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0)return 0;
//        if(coins.length==0) return -1;
//        int[] dp=new int[coins.length+1];
//        dp[0]=Integer.MAX_VALUE;
//        Arrays.sort(coins);
//        for(int i=1;i<=coins.length;i++){
//            //如果当前coins的值比返回dp[i-1]即可
//            if(coins[i-1]>amount){
//                //下面为了避免只有一个值的时候返回Max_value
//                if(coins.length==1) return coins[0]==amount?1:-1;
//                return dp[i-1];
//            }
//            if(dp[i-1]==-1){
//                dp[i]=times(coins,i-1,amount);
//            }else {
//                dp[i] = Math.min(dp[i - 1], times(coins, i - 1, amount));
//            }
//            System.out.println("dp:"+i+",="+dp[i]+",coin:"+coins[i-1]);
//        }
//        return dp[coins.length];
//    }
//    public int times(int[] coins,int end,int amount){
//        //下面也可以把num去掉，用amount相减直到等于0
////        int num=0;
//        int times=0;
//        while(end>=0){
//            while(amount!=0){
//                if(coins[end]>amount)break;
//                amount-=coins[end];
//                times++;
//            }
//            if(amount==0) return times;
//            end--;
//        }
//        return -1;
//    }
}
