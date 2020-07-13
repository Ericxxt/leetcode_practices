public class MaximalSquare221 {
    int max_square=0;
    public int maximalSquare(char[][] matrix) {
            if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]=='1'){
//                        System.out.println("x:"+i+",y:"+j);
                        bts_recursion(matrix,i,j,1);
                        max_square=Math.max(max_square,1);
                    }
                }
            }
            return max_square;
    }

    //自己想的方法
    //Runtime: 4 ms, faster than 88.40% of Java online submissions for Maximal Square.
    //Memory Usage: 43.6 MB, less than 91.18% of Java online submissions for Maximal Square.
    public void bts_recursion(char[][] matrix,int x,int y,int length){
        if(x+length>=matrix.length||y+length>=matrix[0].length) return;
        for(int i=x+length;i>=x;i--){
            if(matrix[i][y+length]=='0') return;
        }
        for(int j=y+length;j>=y;j--){
            if(matrix[x+length][j]=='0') return;
        }
        bts_recursion(matrix,x,y,length+1);
        max_square=Math.max(max_square,(length+1)*(length+1));
        return;
    }
    // dp solution in leetcode
//    public int maximalSquare(char[][] a) {
//      if (a == null || a.length == 0 || a[0].length == 0)
//        return 0;
//
//      int max = 0, n = a.length, m = a[0].length;
//
//      // dp(i, j) represents the length of the square
//      // whose lower-right corner is located at (i, j)
//      // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
//      int[][] dp = new int[n + 1][m + 1];
//
//      for (int i = 1; i <= n; i++) {
//        for (int j = 1; j <= m; j++) {
//          if (a[i - 1][j - 1] == '1') {
//            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
//            max = Math.max(max, dp[i][j]);
//          }
//        }
//      }
//
//      // return the area
//      return max * max;
//    }
}
