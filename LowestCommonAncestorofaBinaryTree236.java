public class LowestCommonAncestorofaBinaryTree236 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //这题迭代的思想真的想了很久，真的很难想到呀，感觉和之前一道很难的题目很像
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          //如果头节点就找到了那么直接输出头节点
          if(root==null||root==p||root==q) return root;
          //分两路去找，得到的节点会是ancestor
        //如果某一路得不到值，那一直迭代返回的就是null
          TreeNode left_node=lowestCommonAncestor(root.left,p,q);
          TreeNode right_node=lowestCommonAncestor(root.right,p,q);
          //如果左节点是null那么毫无疑问答案在右边节点（这种情况头节点不是ancestor了，因为如果是第一行已经输出了）
        //如果左节点不是null那么判断右边，如果右边也不是null说明只能是root节点，是null的话就输出左节点
          return left_node==null?right_node:right_node==null?left_node:root;
    }
//  TreeNode LCA_node=null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//          if(root==null) return null;
//          if(root==p){
//              LCA_node=root;
//
//          }
//    }
//    public void reversion_ancestor(TreeNode root,TreeNode p,TreeNode q,TreeNode ancestor_node){
//        if(root==null||LCA_node!=null) return;
//
//    }
//    boolean found_another=false;
//    public boolean search(TreeNode root,TreeNode another_node){
//        if (found_another) return true;
//        if(root==null) return false;
//        if(root.val==another_node.val){
//         found_another=true;
//         return found_another;
//        }
//        search(root.left,another_node);
//        search(root.right,another_node);
//        return found_another;
//    }
}
