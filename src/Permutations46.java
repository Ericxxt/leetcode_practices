import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        recursion_method(lists,new ArrayList<>(),nums);
        return lists;

    }
    public static void recursion_method(List<List<Integer>> lists,List<Integer> inner_list,int[] nums){
        if(inner_list.size()==nums.length){
            lists.add(new ArrayList<>(inner_list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(inner_list.contains(nums[i])){
                    continue;
                }
                inner_list.add(nums[i]);
                recursion_method(lists, inner_list, nums);
                inner_list.remove(inner_list.size() - 1);
            }
        }

    }


























}
    //我的方法

//    public List<List<Integer>> permute(int[] nums) {
//        List<Integer> loop_list = new ArrayList<>();
//    List<List<Integer>> lists=new ArrayList<>();
//        for (int fst_index = 0; fst_index < nums.length - 1; fst_index++) {
//        for (int sec_index = 1; sec_index < nums.length; sec_index++) {
//            swap_num(nums,fst_index,sec_index);
//            System.out.println("fst:"+nums[fst_index]+",sec:"+nums[sec_index]);
////            for(int i=0;i<nums.length;i++){
////                loop_list.add(nums[i]);
////            }
//            lists.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
//            loop_list.clear();
//            swap_num(nums,fst_index,sec_index);
//        }
//    }
//        return lists;
//
//
//
//}
//    public static void swap_num(int[] nums,int fst_index,int sec_index){//这样子才可以交换数组里面的数据
//        nums[fst_index]+=nums[sec_index];
//        nums[sec_index]=nums[fst_index]-nums[sec_index];
//        nums[fst_index]-=nums[sec_index];
//    }

//   开始的想法

//            for(int i=0;i<nums.length;i++){
//
//            }

//    public static List<List<Integer>> inner_loop(int[] nums,int index,List<Integer> loop_list,List<List<Integer>> lists){
//        if(index==nums.length-1){
//
//        }
//        for(int i=index;i<nums.length;i++){
//
//        }
//    }

