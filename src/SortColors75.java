public class SortColors75 {

    //快速排序，终于写了一次 2019。8。24
    public void sortColors(int[] nums) {
            quick_sort(nums,0,nums.length-1);
    }
    public static void quick_sort(int[] nums,int low,int high){
        if(low>high){
            return;
        }
        //如果这里i设置为low+1，那么当low和high的值相同时，下面nums[LOW]=nums[I]会存在问题
        int i=low;
        int j=high;
        int temp=nums[low];
        while (j>i){
            while(temp<=nums[j]&&i<j){
                j--;
            }
            //重点
            //如果是先+的话，i的index所对应的值可能正好比基准数大，所以应该先减！！！！！！！！！！！
            while(temp>=nums[i]&&i<j){
                i++;
            }
            System.out.println("nums_i:"+nums[i]+",nums[j]:"+nums[j]);
            if(i!=j) {
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
            }
        }
        System.out.println("i:"+i);
        for(int x=0;x<nums.length;x++){
            System.out.print(nums[x]);
        }
        System.out.println("low:"+low+",high:"+high+",over");
        nums[low]=nums[i];
        nums[i]=temp;

        quick_sort(nums,low,j-1);
        quick_sort(nums,j+1,high);

    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,0,2,1,1,0};
        quick_sort(nums,0,nums.length-1);
    }
}
