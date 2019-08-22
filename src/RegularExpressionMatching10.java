public class RegularExpressionMatching10 {

    //          ab=.* -> true

    //boolean dp[i][j]的含义是s[i]与p[j]是否匹配

    public static boolean isMatch(String s, String p) {

        if( s ==null || p == null){
            return false;
        }
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];// boolean数组初始化时必须加上一位，因为起始为0
        dp[0][0]=true;
        //循环打印
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=p.length();j++){
                System.out.println("dp[i][j]:"+dp[i][j]);
            }
        }
        /*
         *condition1:  相同字符匹配  或者    遇到.
         *  s[i]==p[j]  --> dp[i][j]==dp[i-1][j-1]
        *
        * condition2:
        *
        *   if(p[j]=="."){
        *       dp[i][j]==dp[i-1][j-1]
        *   }
        *   1.   aa a* or .*
        *   if(p[j]=="*"){
        *  if(s[i]==p[j-1]|| p[j-1]=="."){
        *           dp[i][j]=dp[i][j-2] || dp[i-1][j]    a*与aa的情况下，dp[1][2]=dp[1][0]是空的   因为初始化的时候 所有带*号的dp[i][j]=dp[i][j-2]
        *  }else{
        *           dp[i][i]=dp[i][j-2]      //因为不match不代表直接false可能a*之前是match的
        *  }
        *}

        * */
       for(int i=1;i<=p.length();i++){
           if(p.charAt(i-1)=='*'){
               dp[0][i]=dp[0][i-2];
           }
       }

       for(int i=1;i<=s.length();i++){
           for(int j=1;j<=p.length();j++){
               if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='.'){
                   dp[i][j]=dp[i-1][j-1];
               }else if(p.charAt(j-1)=='*'){
                   if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){
                       dp[i][j]=dp[i][j-2]||dp[i-1][j];
                   }else{
                       dp[i][j]=dp[i][j-2];      //因为不match不代表直接false可能a*之前是match的
                   }
               }
           }
       }


       return dp[s.length()+1][p.length()+1];
    }

    public static void main(String[] args) {
        String s="abbcabee";
        String p=".*a*cabe*";
        isMatch(s,p);
    }
}
