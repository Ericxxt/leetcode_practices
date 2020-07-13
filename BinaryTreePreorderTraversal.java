import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> preorderTraversal(TreeNode root) {
            return recur_preorder(new ArrayList<>(),root);
    }
    public List<Integer> recur_preorder(List<Integer> list,TreeNode node){
          if(node==null)return list;
            list.add(node.val);
          recur_preorder(list,node.left);
          recur_preorder(list,node.right);
          return list;
    }
}
