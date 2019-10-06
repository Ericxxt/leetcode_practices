import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    //2019.08.31
//    Runtime: 28 ms, faster than 31.51% of Java online submissions for Combinations.
//    Memory Usage: 41.5 MB, less than 15.22% of Java online submissions for Combinations.
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> large_list=new ArrayList<>();
        if(n==0||k==0){
            return large_list;
        }
        recursion_combine(large_list,new ArrayList<>(),1,n,k);
        return large_list;
    }
    public void recursion_combine(List<List<Integer>> large_list,List<Integer> small_list,int current_index,int n,int k){
        if(small_list.size()==k){
            large_list.add(new ArrayList<>(small_list));
            return;
        }
        for(int i=current_index;i<=n;i++){
            small_list.add(Integer.valueOf(i));
            //下面这行使用++current_index是关键，如果不是用++current——index， current值一直都不会改变，用i+1也可以更好理解但是速度慢
            recursion_combine(large_list,small_list,++current_index,n,k);
            small_list.remove(small_list.size()-1);
        }
    }
}
