import java.util.Stack;

public class ReverseLinkedListII {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //2019/10/07
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
  //Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
    public static ListNode reverseBetween(ListNode head, int m, int n) {
          if(m==n){
              return head;
          }
        Stack<ListNode> stack=new Stack<>();
        int i=1;
        //CREAT A NODE THAT IS BEFORE THE HEAD,IT WOULD BE EASIER TO MARK THE ONE BEFORE THE M
        ListNode front_node=new ListNode(-1);
        front_node.next=head;
        while(i!=m){
            front_node=front_node.next;
            i++;
        }
        ListNode behind_node=front_node;
        for(int index=0;index<=n-m;index++){
            stack.push(behind_node.next);
            behind_node=behind_node.next;
        }
        if(m==1){//如果起始点开始reverse，那么head就要变成n所在的元素
            head=stack.peek();
        }
        behind_node=behind_node.next;
//        if(behind_node.next==null){//这种情况表示n标记的是最后一个结点
//
//        }
//        ListNode wrap_node;
//        wrap_node=front_node;
        while(!stack.isEmpty()){
            System.out.println("stack_peek:"+stack.peek().val);
            front_node.next=stack.pop();
            front_node=front_node.next;
            System.out.println("front_node:"+front_node.val);
        }
        front_node.next=behind_node;

            return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        head.next=new ListNode(5);
        System.out.println("head:"+reverseBetween(head,1,2).val);

    }
}
