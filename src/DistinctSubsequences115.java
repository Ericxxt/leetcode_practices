public class DistinctSubsequences115 {

    public int numDistinct(String s, String t) {
        // 0babgbag
        //011111111
        //b
        //a
        //g
        //每一个目标字符是否对于整体成立都是建立在这个字符之前的字符也成立的条件之下，也就是说如果测试字符是
        // 0gbag
        //0
        //b
        //a
        //g00
        //即使g对到位置，其值还是0

        //如上图所示，横轴是测试字符串s，纵轴是字符串t结果会累加，所以答案就是dp[s.length+1][t.length+1]
        int[][] dp=new int[t.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[0][i]=1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    //dp[i][j]就是代表着之前的一个对位的字母，因为即使不是刚好对位
                    //但是因为dp[i+1][j+1]=dp[i+1][j]，这个数字会延续，所以dp[i+1][j+1]
                    //的对角元素dp[i][j]就刚好是t字符中前一个字符的对位
                    dp[i+1][j+1]=dp[i][j]+dp[i+1][j];
                }else{
                    dp[i+1][j+1]=dp[i+1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
    // I contend it can work,but time limited....
//    public int numDistinct(String s, String t) {
//        if(t.length()==0||s.length()==0||s.length()<t.length()){
//        return 0;
//        }
//        if(s.length()==t.length()){
//            return s.equals(t)?1:0;
//        }
//        recur(s,t,0,0);
//        return num;
//    }
//    int num=0;
//    public void recur(String s,String t,int index_s,int index_t){
//        if(index_t==t.length()){
//            num++;
//            return;
//        }
//       for(int i=index_s;i<s.length();i++){
//           //index_t和t.LENTH相对应
//           if(s.charAt(i)==t.charAt(index_t)){
//               recur(s,t,i+1,index_t+1);
//           }
//       }
//       return;
//    }
}
