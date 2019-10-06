public class RemoveDuplicatesfromSortedList83 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
//    Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
//          2019.09.03
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode present_node=head;
        ListNode last_part_node=head;
        int count=1;
        while (present_node.next!=null){
            if(present_node.next.val==present_node.val){
                count++;
            }else{
                //特殊情况，head开始就已经重复了
                if(count>1) {
                    // if (last_part_node == head) {
                    //     head = present_node;
                    // }else {
                    last_part_node.next = present_node.next;
                    // }
                }
                last_part_node=present_node.next;
                count=1;
            }
            present_node=present_node.next;
        }
        //为了最后重复没有被删去的情况
        if(count!=1){
            last_part_node.next=null;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
