public class SortList148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        //下面这段不需要
//        if(head.next.next==null){
//            if(head.val>head.next.val){
//                ListNode start_node=head.next;
//                start_node.next=head;
//                head.next=null;
//                return start_node;
//            }
//        }
        ListNode slow_node=head;
        ListNode faster_node=head;
        while(faster_node.next!=null&&faster_node.next.next!=null){
            slow_node=slow_node.next;
            //这里又写错了，找了好久的bug
//            faster_node=faster_node.next;
            faster_node=faster_node.next.next;
        }
        faster_node=slow_node.next;
        slow_node.next=null;
        ListNode fir_node=sortList(head);
        ListNode sec_node=sortList(faster_node);
        return mergeList(fir_node,sec_node);
    }
    public ListNode mergeList(ListNode list1,ListNode list2){
        ListNode start_node=new ListNode(0);
        ListNode merge_node=start_node;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                merge_node.next=list1;
                list1=list1.next;
            }else{
                merge_node.next=list2;
                list2=list2.next;
            }
            merge_node=merge_node.next;
        }
        if(list1!=null){
            merge_node.next=list1;
        }
        if(list2!=null){
            merge_node.next=list2;
        }
        return start_node.next;
    }
}
