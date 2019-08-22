import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {              //verify that the length is larger than 4
            return lists;
        }
        Arrays.sort(nums);

//
//        if (nums[0] > target || nums[nums.length - 1] < target) {       //verify the arrays could be zero
//            return lists;
//        }
        int i;
        int l1;
        int l2;
        for (int l3 = nums.length - 1; l3 > 2; l3--) {
            for (i = 0; i < l3-2; i++) {

                l2=l3-1;
                l1=i+1;

                while(l1<l2) {
                    addArrays(nums, i, l1, l2, l3, lists,target);//即使到了0还是需要判断，因为可能左边进一位，右边退一位值还是相等的
                    if(nums[i]+nums[l1]+nums[l2]+nums[l3]>target){
                        l2--;
                    }else if(nums[i]+nums[l1]+nums[l2]+nums[l3]<target){
                        l1++;
                    }else{
                        l2--;
                        l1++;
                    }
                }
            }
        } //for l3
        return lists;
    }
    public static boolean addArrays(int[] nums, int i,int l1,int l2, int l3,List<List<Integer>> list,int target){
        if(nums[i]+nums[l1]+nums[l2]+nums[l3]==target){
            if(!list.contains(Arrays.asList(nums[i],nums[l1],nums[l2],nums[l3]))) {
                list.add(Arrays.asList(nums[i], nums[l1], nums[l2], nums[l3]));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums,-11).toString());
    }
}
