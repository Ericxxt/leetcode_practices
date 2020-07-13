public class NumberofIslands200 {
    //用dp想了好久都没想出来，还是用dfs迭代比较靠谱
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid,int i,int j){
        if(i<0||i>grid.length||j<0||j>grid[0].length||grid[i][j]!='1') return;
        grid[i][j]='0';
        //四个方向迭代
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        return;
    }
//    public int numIslands(char[][] grid) {
//        if(grid.length==0||grid[0].length==0) return 0;
//        int[][] dp=new int[grid.length][grid[0].length];
//        for(int i=1;i<=grid.length;i++){
//            for(int j=1;j<=grid[0].length;j++){
//                if(grid[i-1][j-1]==1){
//                    if(grid[i-1][j]==0&&grid[i][j-1]==0){
//
//                    }
//                }else{
//                    dp[i][j]
//                }
//            }
//        }
//    }
}
