import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> large_list=new ArrayList<>();
        large_list.add(new ArrayList<>());
        if(nums.length==0){
            return large_list;
        }
        for(int j=1;j<=nums.length;j++){
            recursion_subsets(large_list,new ArrayList<>(),0,j,nums);
        }
        return large_list;
    }
    public void recursion_subsets(List<List<Integer>> large_list,List<Integer> small_list,int current_index,int k,int[] nums){
        if(small_list.size()==k){
            large_list.add(new ArrayList<>(small_list));
            return;
        }
        for(int i=current_index;i<nums.length;i++){
            small_list.add(Integer.valueOf(nums[i]));
            //下面这行使用++current_index是关键，如果不是用++current——index， current值一直都不会改变，用i+1也可以更好理解但是速度慢
            recursion_subsets(large_list,small_list,++current_index,k,nums);
            small_list.remove(small_list.size()-1);
        }
    }
}
