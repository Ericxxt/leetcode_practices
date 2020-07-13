import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber136 {
    //leetcode 一个用位运算的人
    //we use bitwise XOR to solve this problem :
    //
    //first , we have to know the bitwise XOR in java
    //
    //0 ^ N = N
    //N ^ N = 0
    //So..... if N is the single number
    //
    //N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    //
    //= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    //
    //= 0 ^ 0 ^ ..........^ 0 ^ N
    //
    //= N
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++)
            //^是位异或运算 不同的位数可以被保留到最后相同的数都被消除
            //^=  类比于+=行为，就是ans = ans ^nums[i]
            ans ^= nums[i];
        return ans;
    }
    //用自己方法做的
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int num=nums[0];
//        int count=1;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]!=num){
//                if(count==1){
//                    return num;
//                }else{
//                    num=nums[i];
//                    count--;
//                }
//            }else {
//                count++;
//            }
//        }
//        return 0;
//    }
    //还是很慢
//    public int singleNumber(int[] nums) {
//        Set<Integer> set=new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            if(set.contains(nums[i])){
//                set.remove(Integer.valueOf(nums[i]));
//            }else{
//                set.add(nums[i]);
//            }
//        }
//        return set.iterator().next();
//    }

}
