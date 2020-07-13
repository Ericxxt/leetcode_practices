public class ShortestUnsortedContinuousSubarray581 {
//    高票答案
    public int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        //下面这种方法很巧妙，
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            //因为A[i]<max 说明max是之前的并不是当前A[i],如果是就会是相等了
            //所以这个i就是在遇到右边界end的之前一个元素
            //下边的beg也是同理，思路和我下面写的一样，但是简洁太多了
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
//    public int findUnsortedSubarray(int[] nums) {
//        if(nums.length==1) return 0;
//        int count=0;
//        int max_index=0;
//        int min_index=0;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]<nums[i-1]){
//                min_index=i;
//            }else{
//                max_index=nums[max_index]>nums[i]?max_index:i;
//
//            }
//
//        }
//    }
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Shortest Unsorted Continuous Subarray.
    //Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Shortest Unsorted Continuous Subarray.
    //自己想的方法
    //下面这题的思路就是先找到左边开始和不符合排序的index，
    //再找到右边开始不符合排序的index，
    //然后再这个左右index之间循环找到最大值还有最小值
    //然后在左边找到比最小值大的数字的index就是左边开始需要排序的位置，
    //然后在右边找到比最大值小的数字的index就是右边开始需要排序的位置，
    //结果等于right=left+1就是需要排序的个数
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==1) return 0;
        int left,right;
        left=0;
        right=nums.length-1;
        boolean find_left,find_right;
        find_left=find_right=false;
        //思考如果数组都等于同一个值的情况
        while ((!find_left||!find_right)&&left<right){
            if(!find_left) {
                if (nums[left] <= nums[left + 1]) {
                    left++;
                }else{
                    find_left=true;
                }
            }
            if(!find_right) {
                if (nums[right] >= nums[right - 1]) {
                    right--;
                }else{
                    find_right=true;
                }
            }
        }
        //思考如果数组都等于同一个值的情况
        if(left==right) return 0;
        int max=nums[left];
        int min=nums[left];
        for(int i=left+1;i<=right;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        for(int i=0;i<left;i++){
            if(nums[i]>min){
                left=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=right;i--){
            if(nums[i]<max){
                right=i;
                break;
            }
        }
        return right-left+1;
    }
}
