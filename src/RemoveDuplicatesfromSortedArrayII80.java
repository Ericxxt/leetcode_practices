public class RemoveDuplicatesfromSortedArrayII80 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<3){
            return nums.length;
        }
            int altered_len=nums.length;
//            int initial_index=0;
            int now_num=nums[0];
            int count=1;
            int start_pos=0;
            for(int initial_index=1;initial_index<altered_len;initial_index++){
//                for (int i = 0; i < altered_len; i++) {
//                    System.out.print(nums[i]+",");
//                }
//                System.out.println("***********");
                //count归零之后，当前新一轮的now_num数值变化为当前值
//                if(count==0){
//                    now_num=nums[initial_index];
//                }
                if(nums[initial_index]==now_num){
                    //要首先count++不然下面的if判断就延迟没有意义了
                    count++;
                    if(count==3){
                        start_pos=initial_index;
                    }
                }else{
                    if(count<3){
                    }else{

//                        System.out.println("gedgwsegwse,count:"+count+"start_pos:"+start_pos+",now_num"+now_num);
                        //arraycopy最后一个参数是数组长度，所以比index还会+1
                        System.arraycopy(nums,start_pos+count-2,nums,start_pos,altered_len-start_pos-count+2);
                        altered_len=altered_len-count+2;
                        //重点！！！！！！！！！！！！数组变化以后initial——index位置也应该发生变化
                        initial_index=start_pos;
                    }
                    now_num=nums[initial_index];
                    count=1;
                }
            }
            if (count>2){
                altered_len=altered_len-count+2;
            }
            return altered_len;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2,2,3,3};
        removeDuplicates(nums);
        int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+",");
        }
    }
}
