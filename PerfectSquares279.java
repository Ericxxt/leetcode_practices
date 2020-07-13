import java.util.Arrays;

public class PerfectSquares279 {
//    public int numSquares(int n) {
//        int[] dp=new int[n];
//        for(int i=0;i<n;i++){
//            int remainder=is_square_num(i+1);
//            if(remainder==0){
//                //刚好就是平方数，赋值为1
//                dp[i]++;
//            }else{
//                //不是平方数
//                while(remainder!=0){
//                    remainder=is_square_num(remainder);
//                    dp[i]++;
//                }
//                int j=i-1;
//                //下面的对比上面数字开根产生的次数和
//                //从当前index一直后退到正好是平方数的index的那个位置，dp[i]=dp[index]+times[i-index]
//                while(j>=0){
//                    int times=0;
//                    remainder=is_square_num(i-j);
//                    times++;
//                    while(remainder!=0){
//                        remainder=is_square_num(remainder);
//                        times++;
//                    }
//                    dp[i]=Math.min(dp[i],dp[j]+times);
//                    if(dp[j]==1) break;
//                    j--;
//                }
//            }
//            System.out.println("dp:"+dp[i]);
//        }
//        return dp[n-1];
//    }
    //leetcode方法
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1]+1;
            int j = 2;
            while(i - j*j >= 0) {
//                i-(j*j)==0就表示正好开根号了
                //不需要像我dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);这样判断，因为最小肯定出现在上一个平方数或平方数的倍数
                //下面式子成立的原因

//                dp[i-j*j]+1=dp[i-j*j]+dp[j*j]
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                ++j;
            }
        }
        return dp[n];
    }
    //下面是自己想的方法
    //突然想到一个更加简便的方法
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int remainder=is_square_num(i);
            if(remainder==0){
                dp[i]++;
            }else{
                dp[i]=dp[remainder]+1;
                int j=i/2;
                while(j<i){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
                    //因为已经是余数，不可能比2更小了
                        if(dp[i]==2) break;
                    j++;
                }
            }
        }
        return dp[n];
    }
    public int is_square_num(int n){
        if(n==1) return 0;
        int cal_num=(int)Math.sqrt(n);
        return n-cal_num*cal_num;
    }
}
