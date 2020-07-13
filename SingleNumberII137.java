import java.util.Arrays;

public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num=nums[0];
        int times=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=num){
                if(times==1){
                    return num;
                }else{
                    num=nums[i];
                    times=1;
                }
            }else{
                times++;
            }
        }
        return num;
    }
}
