public class BalancedBinaryTree110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //Runtime: 1 ms, faster than 99.89% of Java online submissions for Balanced Binary Tree.
    //Memory Usage: 38.5 MB, less than 89.82% of Java online submissions for Balanced Binary Tree.
    boolean tf=true;
    public boolean isBalanced(TreeNode root) {
        recur(root,0);
        return tf;
    }
    public int recur(TreeNode root,int level){
        int left_length=0;
        int right_length=0;
        if(tf) {
            if (root == null) {
                return level;
            }
            left_length = recur(root.left, level + 1);
            right_length = recur(root.right, level + 1);
            if (Math.abs(left_length - right_length) > 1) {
                tf = false;
            }
        }
        //这一步是关键，左子树与右子树比较是不会用最小的层进行比较，而是用左右两边最大的层级，因此是max左右两边
        return Math.max(left_length,right_length);
    }
}
