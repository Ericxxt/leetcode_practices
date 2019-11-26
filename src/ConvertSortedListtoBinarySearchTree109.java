public class ConvertSortedListtoBinarySearchTree109 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return bst(head,null);
    }
//    public TreeNode toBST(ListNode head, ListNode tail){
//        ListNode slow = head;
//        ListNode fast = head;
//        if(head==tail) return null;
//
//        //下面的while循环十分神奇，fast走两步，slow走一步，因此slow就刚好是node的中点
//        while(fast!=tail&&fast.next!=tail){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        TreeNode thead = new TreeNode(slow.val);
//        thead.left = toBST(head,slow);
//        thead.right = toBST(slow.next,tail);
//        return thead;
//    }
    //下面的方法是vote最高的方法
    //Runtime: 1 ms, faster than 98.16% of Java online submissions for Convert Sorted List to Binary Search Tree.
//Memory Usage: 39 MB, less than 94.74% of Java online submissions for Convert Sorted List to Binary Search Tree.
    public TreeNode bst(ListNode start,ListNode end){
          ListNode slow=start;
          ListNode fast=start;
          if (start==end) return null;
        //下面的while循环十分神奇，fast走两步，slow走一步，因此slow就刚好是node的中点
          while(fast!=end&&fast.next!=end){
              fast=fast.next.next;
              slow=slow.next;
          }
          TreeNode root=new TreeNode(slow.val);
          root.left=bst(start,slow);
          root.right=bst(slow.next,end);
          return root;
    }
    //下面这种方法写了很久，发现并不是很好，因为结点的右边会进行叶子结点的转换，但是左边不会
    //有空想
//        public TreeNode sortedListToBST(ListNode head) {
//          if(head==null){
//              return null;
//          }
////        final_node=new TreeNode(head.val);
//            TreeNode pre_node=null;
//            TreeNode cur_node=null;
//            int node_num=0;
//          while (head!=null){
//              if(node_num%2==0){
//                  if(node_num==0){
//                      pre_node=new TreeNode(head.val);
//                  }else{
//                      pre_node.right=new TreeNode(head.val);
//                  }
//              }else{
//                  cur_node=new TreeNode(head.val);
//                  cur_node.left=pre_node;
//                  pre_node=cur_node;
////                  System.out.println("cur_node.val:"+cur_node.val+"cur.left:"+cur_node.left.val);
//              }
//              head=head.next;
//              node_num++;
//          }
//          if(node_num<4||cur_node==null){
//              return pre_node;
//          }
////            node_num=node_num/4>0?node_num/4-1:0;
//            node_num=node_num/4;
//          while(node_num>0){
//              cur_node=pre_node.left;
//              pre_node.left=cur_node.right;
//              cur_node.right=pre_node;
//              pre_node=cur_node;
//              node_num--;
//          }
//            System.out.println("pre_node.val:"+pre_node.val);
//            System.out.println("cur_node.val:"+cur_node.val);
//          return cur_node;
//    }
    //有空想



//    public void recur(ListNode head,TreeNode node,)
//        TreeNode final_node=null;
//    public TreeNode sortedListToBST(ListNode head) {
//          if(head==null){
//              return null;
//          }
//        final_node=new TreeNode(head.val);
//          recur_gene(head,new TreeNode(head.val));
//          node_num=node_num/2-1;
//          while(node_num>0){
//              final_node=final_node.left;
//              node_num--;
//          }
//          TreeNode goal_node=final_node.left;
//          final_node.left=goal_node.right;
//          goal_node.right=final_node;
//          return goal_node;
//    }
//        int node_num=1;
//        TreeNode final_node=null;
//    public void recur_gene(ListNode head,TreeNode node){
//          if(head.next!=null) {
//              if (node_num % 2 == 0) {
//                  node.right=new TreeNode(head.next.val);
//                  node_num++;
//                  if(head.next.next!=null) {
//                      recur_gene(head.next, node);
//                  }else{
//                      final_node=node;
//                  }
//              }else{
//                  TreeNode next_node = new TreeNode(head.next.val);
//                  next_node.left=node;
//                  node_num++;
//                  if(head.next.next!=null) {
//                      recur_gene(head.next, next_node);
//                  }else{
//                      final_node=next_node;
//                  }
//              }
//          }
//          return;
//    }

}
