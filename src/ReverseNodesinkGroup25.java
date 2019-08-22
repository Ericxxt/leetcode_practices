public class ReverseNodesinkGroup25 {

//    Given this linked list: 1->2->3->4->5
//
//    For k = 2, you should return: 2->1->4->3->5
//
//    For k = 3, you should return: 3->2->1->4->5


    //k如果不是lisrnode的倍数的话，多余的是需要留下的

    //可以使用stack更方便，但是需要额外空间，不满足leetcode的要求

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
            return head;
        }
        int List_length=1;
        ListNode test_node=head;
        while(test_node.next!=null){
            List_length++;
            test_node=test_node.next;
        }
        if(k>List_length){
            return head;
        }
        int start_position=List_length-List_length%k;

        test_node=head;
        ListNode wait_for_conn =null;
        if(List_length%k!=0) {
            wait_for_conn=start_node(test_node,start_position+1);//不在转换范围内的第一个元素
            test_node=head;
        }
        ListNode final_node=null;
        ListNode prepared_wait=null;
        for(int i=0;i<(List_length/k);i++){        //这个循环把每一组的链表进行相互的调换
            for(int j=start_position-i*k-1;j>(start_position-(i+1)*k);j--){
                ListNode circle_node=start_node(head,j);
                System.out.println("circle_node.val:"+circle_node.val);
                exchange(circle_node);
                if(j==start_position-i*k-1){
                    prepared_wait=circle_node.next;
                    if(j==k-1){
                        final_node=circle_node.next;
                    }
                }
                if(j==start_position-(i+1)*k+1){
                    circle_node.next=wait_for_conn;
                    wait_for_conn=prepared_wait;
                }
            }
        }

        return final_node;

    }

    public static ListNode start_node(ListNode node_parameter,int postion){ //不会改变node_parameter的值 神奇！！！！！！！！！！！！！！！！！
        for(int i=1;i<postion;i++){
            node_parameter=node_parameter.next;
        }
        return node_parameter;
    }
    public static void exchange(ListNode l1){
        l1.next.next=l1;
    }
//
//    public static void main(String[] args) {
//         class ListNode {
//            int val;
//            ListNode next;
//            ListNode(int x) { val = x; }
//        }
//        ListNode head=new ListNode(1);
//        ListNode test_node=head;
//        for(int i=2;i<11;i++){
//
//            head.next=new ListNode(i);
//            head=head.next;
//        }

//        ListNode end_node=reverseKGroup(test_node,3);

//                while(end_node.next!=null) {
//            System.out.println(end_node.val);
//                    end_node=end_node.next;
//        }
//        System.out.println(reverseKGroup(test_node,3).val);
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null && count != k) { // find the k+1 node
//            curr = curr.next;
//            count++;
//        }
//        if (count == k) { // if k+1 node is found
//            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
//            // head - head-pointer to direct part,
//            // curr - head-pointer to reversed part;
//            while (count-- > 0) { // reverse current k-group:                   (i-->0) 就是先判断i是否大于0，然后i再自减：i=i-1!!!                       // leetcode上面很快的方法，但是这步有点难懂
//                ListNode tmp = head.next; // tmp - next head in direct part
//                head.next = curr; // preappending "direct" head to the reversed list
//                curr = head; // move head of reversed part to a new node
//                head = tmp; // move "direct" head to the next node in direct part
//            }               //终于读懂了！！！！！！
//            head = curr;
//        }
//        return head;
//    }
//}
