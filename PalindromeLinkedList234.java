public class PalindromeLinkedList234 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public boolean isPalindrome(ListNode head) {
            ListNode faster=head,slow=head;
            //faster有两种情况，一种等于最后一个节点，另一种等于null
            while(faster!=null&&faster.next!=null){
                faster=faster.next.next;
                slow=slow.next;
            }
            if(faster!=null){
                slow=slow.next;
            }
            //slow表示的是后半部分的开始节点，如果链表个数是奇数个，就是最中间后面那个，偶数个就是一半的之后开始的元素
            slow=reverse_node(slow);
            while(slow!=null){
                if(slow.val!=head.val) return false;
                slow=slow.next;
                head=head.next;
            }
            return true;
    }
    //反转后半链表
    public ListNode reverse_node(ListNode node){
          ListNode temper_node=null;
          ListNode pre_node=node;
          while(node!=null&&node.next!=null){
              temper_node=node.next;
              node.next=node.next.next;
              temper_node.next=pre_node;
              pre_node=temper_node;
          }
          return pre_node;
    }
}
