public class ReverseLinkedList206 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode pre_node=head;
        ListNode change_node=null;
        while(head.next!=null){
            change_node=head.next;
            //下面这步不要放到最后面，
            head.next=head.next.next;
            change_node.next=pre_node;
            pre_node=change_node;
        }
        return pre_node;
    }
}
