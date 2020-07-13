import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray448 {
    //这个题目有个很关键的条件就是1 ≤ a[i] ≤ n (n = size of array)注意括号里
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //这题的解法实在是太巧妙了
        //因为总共有n个数，然后缺失了k个数，所以也会重复k个数，
        //我们利用缺失的数字index所对应的nums[index]因为这个位置不会被发现，所以一直是正的，其他位置是负的
        //下面的第一层循环遍历的是i所对应的nums[i]而不是nums中的每一个数字
        List<Integer> list=new ArrayList<>();
        int another_index;
        for(int i:nums){
            //下面的i可能已经被更改了，所以要绝对值
            another_index=Math.abs(i)-1;
            //为避免重复数字被重复修改成正数，我们要先判断
            if(nums[another_index]>=0){
                nums[another_index]*=-1;
            }
        }
        for(int index=0;index<nums.length;index++){
            if(nums[index]>0){
                list.add(index+1);
            }
        }
        return list;
    }
}
