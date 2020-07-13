import java.util.List;

public class InsertionSortList147 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //2020/02/15
    public ListNode insertionSortList(ListNode head) {
          if(head==null||head.next==null){
              return head;
          }
          ListNode start_node=head;
          ListNode end_node=head;
          ListNode pre_node=null;
          ListNode unsorted_start=head.next;
          while(end_node.next!=null){//compared node 初始就是链表的第一个node
              ListNode compared_node=start_node;
              while (compared_node!=end_node.next){
                  if(unsorted_start.val<compared_node.val){
//                      change_position(pre_node,compared_node,unsorted_start,start_node,end_node);
                      //这里原本我尝试将下面的判断包装成函数分离出去，但结果发现没有用，可能是和指针有关，见下面的change_position函数
                      //下面的第一个if是假设node需要插入链表的开头
                      if(pre_node==null){
                          end_node.next=unsorted_start.next;
                          unsorted_start.next=compared_node;
                          start_node=unsorted_start;
                      }else {
                          //这里的else是插入链表的中间部分
                          end_node.next = unsorted_start.next;
                          unsorted_start.next = compared_node;
                          pre_node.next = unsorted_start;
                      }
                      break;
                  }
                  //pre结点变成现在正在compared的node
                  pre_node=compared_node;
                  compared_node=compared_node.next;
              }
              pre_node=null;
              //如果没有进行排序，那么end-node向下移一位
              end_node=unsorted_start==end_node.next?unsorted_start:end_node;
              unsorted_start=unsorted_start==end_node.next?unsorted_start.next:end_node.next;
          }
          return start_node;
    }
    //上面提及的方法指针问题和这个例子很像，这里的node指向null不起作用
    public void change(ListNode node,ListNode node2){
           ListNode nos=null;
           nos=node2;
           node2=node;
          node=nos;
          return;
    }
    //最后发现就是这里的start_node问题，如果将start_node设成全局变量就可以了
//    public void change_position(ListNode pre_node,ListNode compared_node,ListNode unsorted_start,ListNode start_node,ListNode end_node){
//        end_node.next=unsorted_start.next;
//        unsorted_start.next=compared_node;
//          if(pre_node==null){
//              start_node=unsorted_start;
//          }else {
//              pre_node.next = unsorted_start;
//          }
//          return;
//    }
}
