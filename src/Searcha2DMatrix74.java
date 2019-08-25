public class Searcha2DMatrix74 {
    //2019/8.23
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
//    Memory Usage: 43.2 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int high=matrix.length-1;
        int low=0;
        int index=0;
        while(high-low>0){
            index=(high+low)/2;
            if(matrix[index][0]>target){
                high=high>1?index-1:0;
            }else if(matrix[0].length==1){
                for(int j=low;j<=high;j++){
                    if(matrix[j][0]==target){
                        return true;
                    }
                }
                return false;
            }else if(matrix[index][0]<=target&&matrix[index][matrix[0].length-1]>=target){
                return search_target(matrix,target,index);
            }else{
                low=index+1;
            }
        }

        return search_target(matrix,target,high);

    }
    public static boolean search_target(int[][] matrix,int target,int row){
        for(int i=0;i<matrix[0].length;i++){
            if (matrix[row][i]==target){
                return true;
            }
        }
        return false;
    }

}
