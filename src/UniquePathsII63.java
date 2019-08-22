public class UniquePathsII63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1||obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            // System.out.println("local:");
            return 0;
        }

        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                // System.out.println("length1:"+obstacleGrid.length+",length2:"+obstacleGrid[0].length);
                if(i==0||j==0){

                    if(obstacleGrid[i][j]==1){
                        obstacleGrid[i][j]=0;
                    }else{
                        if(i==0&&j==0){
                            obstacleGrid[0][0]=1;
                        }else if(i==0){
                            // System.out.println("i:"+i+",j:"+j);
                            obstacleGrid[i][j]=obstacleGrid[i][j-1];

                        }else if(j==0){
                            obstacleGrid[i][j]=obstacleGrid[i-1][j];
                        }
                    }
                }else{
                    if(obstacleGrid[i][j]==1){
                        obstacleGrid[i][j]=0;
                    }else{
                        obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                    }
                }
            }
        }

        //打印for循环输出
        // for(int i=0;i<obstacleGrid.length;i++){
        //         for(int j=0;j<obstacleGrid[0].length;j++){
        //             System.out.println("local2:"+obstacleGrid[i][j]);
        //         }
        // }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid=new int[2][2];
        obstacleGrid[0][0]=0;
        obstacleGrid[0][1]=0;
        obstacleGrid[1][0]=1;
        obstacleGrid[1][1]=0;
        System.out.println("uni:"+uniquePathsWithObstacles(obstacleGrid));
    }
}
