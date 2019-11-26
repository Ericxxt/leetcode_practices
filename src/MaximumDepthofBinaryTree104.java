public class MaximumDepthofBinaryTree104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019/10/29
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 39 MB, less than 94.62% of Java online submissions for Maximum Depth of Binary Tree.
    int depth=0;
    public int maxDepth(TreeNode root) {
        traversal(root,0);
        return depth;
    }
    public void traversal(TreeNode root,int curr_level){
        if(root==null){
            return;
        }
        if(curr_level>depth){
            depth=curr_level;
        }
        traversal(root.left,curr_level+1);
        traversal(root.right,curr_level+1);
        return;
    }
}
