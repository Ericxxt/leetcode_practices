public class SymmetricTree101 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
//    Memory Usage: 37.5 MB, less than 74.15% of Java online submissions for Symmetric Tree.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        compare_node(root.left,root.right);
        return tf;
    }
    boolean tf=true;
    public void compare_node(TreeNode r1,TreeNode r2){
        if(tf) {
            if (r1 == null && r2 == null) {
                return;
            } else if (r1 == null && r2 != null||r1!=null&&r2==null) {
                tf = false;
            }else{
                if(r1.val==r2.val){
                    //这里是关键，左子树和右子树相比较
                    compare_node(r1.left,r2.right);
                    compare_node(r1.right,r2.left);
                }else{
                    tf=false;
                }
            }
        }
        return;
    }
}
