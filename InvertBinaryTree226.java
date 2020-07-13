public class InvertBinaryTree226 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //  so fucking easy!!!
    //2020/03/04
  //Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
  //Memory Usage: 37.1 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode node=root.left;
        root.left=root.right;
        invertTree(root.left);
        root.right=node;
        invertTree(root.right);
        return root;
    }
}
