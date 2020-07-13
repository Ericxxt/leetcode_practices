import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindtheDuplicateNumber287 {
    //suppose the array is
    //
    //index: 0 1 2 3 4 5
    //
    //value: 2 5 1 1 4 3
    //
    //first subtract 1 from each element in the array, so it is much easy to understand.
    //use the value as pointer. the array becomes:
    //
    //index: 0 1 2 3 4 5
    //
    //value: 1 4 0 0 3 2
    //
    //![enter image description here][1]
    //
    //Second if the array is
    //
    //index: 0 1 2 3 4 5
    //
    //value: 0 1 2 4 2 3
    //
    //we must choose the last element as the head of the linked list. If we choose 0, we can not detect the cycle.
    //
    //Now the problem is the same as find the cycle in linkedlist!

    //我觉得这个算法的思想也太难想到了，关于slow和fast的index赋值可能需要想好几天把
    public int findDuplicate(int[] nums) {
        if(nums.length==0) return -1;
        //因为 nums的个数是n个的话，nums的范围最多取到n-1，所以永远不用担心index溢出
        int slow=nums[0];
        //为什么fast是长这样的呢?
        //把nums[index]想象成一个节点，那么nums[nums[fast]]也就是节点所对应的值
        int fast=nums[nums[0]];
        //这里是重点！！！！！！！！！！！！！！！！！！！！！！！！
        //slow和fast这里相等的意义是之后走同样的步数会碰到相同数字
        //因为当slow或者fast的index是相同值的时候，都会跳转到nums[Duplicate],这才是关键
        while(slow!=fast){

            slow=nums[slow];//slow的下一步就是nums[nums[slow]]
            //所以说slow比fast慢两步
            fast=nums[nums[fast]];
        }
        fast=0;
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return fast;
    }

    //下面是使用set方法做的，但是好像不应该用set做
    //Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
    //上面这句话非常关键，因为数字只会包含n个自然数
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return 0;
    }
    //leetcode高票方法
    //The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/.
    // Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only step each time.
    // They must meet the same item when slow==fast. In fact, they meet in a circle,
    // the duplicate number must be the entry point of the circle when visiting the array from nums[0].
    // Next we just need to find the entry point. We use a point(we can use the fast one before) to visit form begining with one step each time,
    // do the same job to slow. When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.
    int findDuplicate(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
    //    0 2 3 4 5 2 6 1 7
    //看了youtube视频发现还有使用二分法做的
    //1......mid.........n
    //代入leetcode注意函数名字不然会报cannot find symbol mistake
    public int findDuplicate3(int[] nums)
    {
        int left=1;
        int right=nums.length;
        //如果left和right这样取值，得到的中间数就刚刚好
        int mid_num;
        int count1,times;
        while(left<right){
//          while(mid_num<0||mid_num>=nums.length){
            mid_num=(right+left)/2;
            count1=0;
            times=0;
            for (int i = 0; i < nums.length; i++) {
                //注意这里是小于而不是小于等于，所以下面判断count1是与mid_num-1 而不是mid_num
                    if(nums[i]<mid_num){
                        count1++;
                    }else if(nums[i]==mid_num){
                        if(++times>1) return mid_num;
                    }
            }
            //上面的注释解释了count1是与mid_num-1比较 而不是mid_num
            if(count1<=mid_num-1){
                left=mid_num+1;
            }else{
                right=mid_num-1;
            }
        }
          return left;
    }
}
