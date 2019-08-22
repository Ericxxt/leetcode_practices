public class UniquePaths62 {
    //感觉应该是分治法


    //    Similar questions:
    //            91. Decode Ways
    //            70. Climbing Stairs
    //            509. Fibonacci Number

    //DP问题，db实在是太巧妙了，一个点的路径方式是由上一个点（左边或右边决定的）
    public int uniquePaths(int m, int n) {
        int[][] path_matrix=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    path_matrix[i][j]=1;
                }else {
                    path_matrix[i][j]=path_matrix[i-1][j]+path_matrix[i][j-1];
                }
//                System.out.println("j:"+path_matrix[i][j]);
            }
        }
        return path_matrix[m-1][n-1];
    }
}
