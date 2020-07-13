public class LinkedListCycle141 {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public boolean hasCycle(ListNode head) {
          if(head==null) return false;
          ListNode slow_node=head;
          ListNode quick_node=head;
          //这个代码很巧妙，奇数和偶数在一个圈里总会遇到
        while(quick_node.next!=null&&quick_node.next.next!=null){
            slow_node=slow_node.next;
            quick_node=quick_node.next.next;
            if(slow_node==quick_node) return true;
        }
        return false;
    }
}
