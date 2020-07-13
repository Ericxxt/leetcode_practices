public class LinkedListCycleII142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        //        It is called Floyd's algorithm
         //  画了一下图，发现如果节点都是偶数个的话，相交一定在原点因为2*times=times/2 *2
        //To understand this solution, you just need to ask yourself these question.
        //Assume the distance from head to the start of the loop is x1
        //the distance from the start of the loop to the point fast and slow meet is x2
        //the distance from the point fast and slow meet to the start of the loop is x3
        //因为相遇的时候slow的point 走了X1+X2+X3+X2步，fast走了两倍的x1+x2步
        //所以 X1+X2+X3+X2=2(X1+X2), x1=x3,所以设置成将第一个点回到原点，
        //两个点只走一步，刚好可以走到loop开始的那一个点
        if(head==null) return null;
        ListNode slow_node=head;
        ListNode fast_node=head;
        boolean has_loop=false;
        while(fast_node.next!=null&&fast_node.next.next!=null){
            slow_node=slow_node.next;
            fast_node=fast_node.next.next;
            if(slow_node==fast_node){
                has_loop=true;
                break;
            }
        }
        if(!has_loop) return null;
        System.out.println(slow_node.val);
        slow_node=head;
        while(slow_node!=fast_node){
            slow_node=slow_node.next;
            fast_node=fast_node.next;
        }
        return slow_node;
    }
}
