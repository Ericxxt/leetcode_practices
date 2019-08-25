import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes73 {
    //2019。8。23
//    Runtime: 3 ms, faster than 17.02% of Java online submissions for Set Matrix Zeroes.
//    Memory Usage: 49.4 MB, less than 20.00% of Java online submissions for Set Matrix Zeroes.

//修改之后   使用for（ int i : list）迭代用法快出许多                         2019。8。23
//    Runtime: 2 ms, faster than 42.73% of Java online submissions for Set Matrix Zeroes.
//    Memory Usage: 48.8 MB, less than 35.71% of Java online submissions for Set Matrix Zeroes.
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0){
            return;
        }
        List<Integer> row_list=new ArrayList<>();
        List<Integer> column_list=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){

                    if(!row_list.contains(Integer.valueOf(i))){
                        row_list.add(i);
                    }
                    if (!column_list.contains(Integer.valueOf(j))){
                        column_list.add(j);
                    }
                }
            }
        }
        set_row_zero(matrix,row_list);
        set_colunm_zero(matrix,column_list);
    }
        public static void set_row_zero(int[][] matrix,List<Integer> list){
//        for(int i=list.get();i<list.size();i++) {
                for(int i : list){
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }

    }
        public static void set_colunm_zero(int[][] matrix,List<Integer> list){
    //        for(int j=0;j<list.size();j++) {
            for(int j : list){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
}
