

public class ProductofArrayExceptSelf238 {
    //we can use two directions
    // [2,3,4,5]
    //first multiply
    //[1,2,2*3,2*3*4];
    //second multiply
    // from the contrary direction
    //[1*3*4*5,2*4*5,2*3*5,2*3*4*1]

    public int[] productExceptSelf(int[] nums) {
        int[] output_array=new int[nums.length];
        int t=1;
        for(int i=0;i<nums.length;i++){
            output_array[i]=t;
            t*=nums[i];
        }
        t=1;
        for(int i=nums.length-1;i>-1;i--){
            output_array[i]*=t;
            t*=nums[i];
        }
        return output_array;
    }

    //time limited
//    public int[] productExceptSelf(int[] nums) {
//        int blocked_num=nums[0];
//        int[] output_array=new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            blocked_num=nums[i];
//            nums[i]=1;
//            output_array[i]=nums[0];
//            int j=1;
//            while(j<nums.length){
//                output_array[i]*=nums[j];
//                j++;
//            }
//            nums[i]=blocked_num;
//        }
//        return output_array;
//    }
}
