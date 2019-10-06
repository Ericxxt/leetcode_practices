public class DecodeWays91 {
    //2019。09。13，
    //Runtime: 1 ms, faster than 98.29% of Java online submissions for Decode Ways.
    //Memory Usage: 35 MB, less than 100.00% of Java online submissions for Decode Ways.
    //斐波那契，dp问题
    public static int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
        // char[] chars=s.toCharArray();
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)=='0'){
                //只要0前面的数字不等于1或2，整个就都不可以
                if(s.charAt(i-2)-'0'!=1&&s.charAt(i-2)-'0'!=2){
                    return 0;
                }
                //因为绑定了前面一个数字，所以变化和i-2的一样
                dp[i] = dp[i - 2];
                //下面两个else if都可以，一样快
//            }else if((s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0'<27&&(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0'>9){
            }else if(s.charAt(i-2)!='0'&&Integer.parseInt(s.substring(i-2,i))<27){
                // System.out.println("str:"+s.substring(i-1,i));
                dp[i]=dp[i-1]+dp[i-2];
            }else{
//                System.out.println("str:");
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
