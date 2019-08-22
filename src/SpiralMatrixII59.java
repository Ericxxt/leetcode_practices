public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        if(n==1){
            return new int[][]{{1}};
        }
        int[][] dp=new int[n][n];
        dp[0][0]=1;
        turn_right(dp,0,0,0);
        return dp;

    }
    public static void turn_right(int[][] dp,int x,int y,int count){
        if(count==2){
            return;
        }
        for(;y<dp.length-1;y++){
            if(dp[x][y+1]!=0){
                count++;
                break;
            }else {
                count--;
                dp[x][y + 1] = dp[x][y] + 1;
            }
        }
        turn_down(dp,x,y,count);
        return;
    }
    public static void turn_left(int[][] dp,int x,int y,int count){
        if(count==2){
            return;
        }
        for(;y>0;y--){
            if(dp[x][y-1]!=0){
                count++;
                break;
            }else {
                count--;
                dp[x][y - 1] = dp[x][y] + 1;
            }
        }
        turn_up(dp,x,y,count);
        return;
    }

    public static void turn_down(int[][] dp,int x,int y,int count){
        if(count==2){
            return;
        }
        for(;x<dp.length-1;x++){
            if(dp[x+1][y]!=0){
                count++;
                break;
            }else {
                count--;
                dp[x + 1][y] = dp[x][y] + 1;
            }
        }
        turn_left(dp,x,y,count);
        return;
    }
    public static void turn_up(int[][] dp,int x,int y,int count){
        if(count==2){
            return;
        }
        for(;x>0;x--){
            if(dp[x-1][y]!=0){
                count++;
                break;
            }else {
                count--;
                dp[x - 1][y] = dp[x][y] + 1;
            }
        }
        turn_right(dp,x,y,count);
        return;
    }
}
