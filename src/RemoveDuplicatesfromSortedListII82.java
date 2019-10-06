public class RemoveDuplicatesfromSortedListII82 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
//    Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
//2019。09。03

    //这题真的花很久时间，思考问题的角度很重要
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
        //改进之后：last_part_node初始值是null
        ListNode last_part_node=null;
        int count=1;
        while (present_node.next!=null){
            if(present_node.next.val==present_node.val){
                count++;
            }else{
                //特殊情况，head开始就已经重复了
                //改进之后：不管开头后面，只要数量超过2的都被无视所以count》1的if里面什么都不用写
                if(count>1) {
                    // //最后返回的还是head所以开头还是特殊情况，有下面这段代码保证了开头不会重复，因为我们的last_part_node是在present_node之前的
                    // //加了&&present_node.val==head.val，防止[1,2,2,3]到3的时候head还是1但是head直接被赋值成3
                    // if (last_part_node == head&&present_node.val==head.val) {
                    //      // System.out.println("on");
                    //     // head = present_node.next;
                    //     // last_part_node=head;
                    // }else {
                    //     //还是不能马上变化，因为你不知道present_node是否需要删除
                    //     // last_part_node.next = present_node.next;
                    // }
                }else{
                    if (last_part_node==null) {

                        last_part_node=present_node;
                        //head只需要1次，之后再也不需要变化了
                        head=last_part_node;

                    }else{
                        last_part_node.next=present_node;
                        last_part_node=present_node;
                    }
                }
                count=1;
            }
            present_node=present_node.next;
        }
        //为了最后重复没有被删去的情况
        if(count!=1){
            // System.out.println("in");
            if(last_part_node==null){
                // System.out.println("return null");
                return null;
            }else{
                // System.out.println("next_null");
                //为了防止这种情况[1,2,2]
                last_part_node.next=null;
            }
        }else{
            if(last_part_node==null){
                head=present_node;
            }else{
                last_part_node.next=present_node;
            }
        }
        return head;
    }

}
