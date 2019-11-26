import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle118 {
    //Runtime: 1 ms, faster than 24.18% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 34 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists=new ArrayList<>();
        int level=0;
        int level_num;
        while(numRows>0){
            List<Integer> single_list=new ArrayList<>();
            level++;
            level_num=1;
            while(level_num<=level){
                if(level_num==1||level_num==level){
                    single_list.add(1);
                }else{
                    single_list.add(lists.get(lists.size()-1).get(level_num-2)+lists.get(lists.size()-1).get(level_num-1));
                }
                level_num++;
            }
            lists.add(new ArrayList<>(single_list));
            numRows--;
        }
        return lists;
    }
}
