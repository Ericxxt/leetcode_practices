import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    //2019.09.12这题其实很简单，因为这个数组是需要先排序的
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists =new ArrayList<>();
        if(nums.length==0){
            return lists;
        }
        Arrays.sort(nums);
        recursion_list(lists,new ArrayList<>(),0,nums);
        return lists;
    }
    public void recursion_list(List<List<Integer>> lists,List<Integer> single_list,int index,int[] nums){
        if(index<=nums.length){//这步神奇，这里必须使用<=因为这里添加的index其实是index-1的nums[index-1]
            lists.add(new ArrayList<>(single_list));
        }
        // int i=index;
        while(index<nums.length){
            single_list.add(nums[index]);
            recursion_list(lists,single_list,index+1,nums);
            single_list.remove(single_list.size()-1);
            index++;
            while(index<nums.length&&nums[index]==nums[index-1]){
                index++;
            }
        }
        return;
    }
}
