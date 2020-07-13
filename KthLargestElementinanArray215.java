import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
        for(int num:nums){
            priorityQueue.offer(num);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        //用while一次性解决，但是比较慢
//        while(priorityQueue.size()>k){
//            priorityQueue.poll();
//        }

        return priorityQueue.peek();
    }
    //下面这种是快排虽然很快，但我并不觉得是符合题目要求的，最好使用堆排序
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
}
