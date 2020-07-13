public class ReorderList143 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //1->2->3
    //
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode middle_node=head;
        ListNode sec_start=head;
        while(sec_start.next!=null&&sec_start.next.next!=null){
            //下面两行写错了，这个bug找死我了
//            middle_node=head.next;
//            end_node=head.next.next;
            middle_node=middle_node.next;
            sec_start=sec_start.next.next;
        }
        //1->2->3->4->5->6
        //1->2->3->6->5->4
        // 以middle_node为基准，将后半边的元素反转
        sec_start=middle_node.next;
//        ListNode pre_renode=middle_node.next;
        while (sec_start.next!=null){
           ListNode reve_next=sec_start.next;
            sec_start.next=reve_next.next;
           reve_next.next=middle_node.next;
           middle_node.next=reve_next;
        }
        // 一个从开头开始，另一个从中间开始
        ListNode fir_start=head;
        sec_start=middle_node.next;
        while(fir_start!=middle_node){
            middle_node.next=sec_start.next;
            sec_start.next=fir_start.next;
            fir_start.next=sec_start;
            fir_start=sec_start.next;
            sec_start=middle_node.next;
        }
    }
}
