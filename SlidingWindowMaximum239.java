import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {
    //leetcode 高票方法
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
    // 高票方法再写一遍
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0) return new int[0];
        //下面这步是生成双向链表
        Deque<Integer> deque=new ArrayDeque<>();
        int[] max_array=new int[nums.length-k+1];
        int start=0;
        for(int i=0;i<nums.length;i++){
            //把范围超出的index对应的num poll掉
            //下面错了应该用while而不是if
//            if(!deque.isEmpty()&&deque.peek()<i-k+1){
            while(!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            //将上一次进入队尾的多余值和现在i对应的值比较去掉其中一个
//            if(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            //下面这步保证了deque在进行中不会为空，但是下面这步进入deque的值不能保证大小，也就是大或小都需要进去
            deque.offer(i);
            if(i>=k-1){
                max_array[start++]=nums[deque.peek()];
            }
        }
        return max_array;
    }

    //Runtime: 78 ms, faster than 11.59% of Java online submissions for Sliding Window Maximum.
    //Memory Usage: 47.8 MB, less than 6.25% of Java online submissions for Sliding Window Maximum.
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return nums;
        int[] output_array=new int[nums.length-k+1];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        });
        for(int i=0;i<k;i++){
            priorityQueue.offer(nums[i]);
        }
        //下面的循环次数不够充分，因为先赋值然后再改变优先队列，所以数组的最后一位有问题，另外赋值
        for(int i=k;i<nums.length;i++){
            output_array[i-k]=priorityQueue.peek();
            //Remove(object) method takes O(k). So the time complexity should be O(nK).
            priorityQueue.remove(nums[i-k]);
            priorityQueue.offer(nums[i]);
        }
        output_array[nums.length-k]=priorityQueue.peek();
        return output_array;
    }
}
