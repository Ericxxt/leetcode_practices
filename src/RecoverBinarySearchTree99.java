public class RecoverBinarySearchTree99 {
    //2019/10/26
    //Runtime: 2 ms, faster than 100.00% of Java online submissions for Recover Binary Search Tree.
    //Memory Usage: 42.5 MB, less than 69.23% of Java online submissions for Recover Binary Search Tree.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //这道题目真的很经典重要，这道题题目涉及了中序遍历以及MORRIS tranversal,
    //刚开始一直不理解为什么一定要使用中序遍历，后来才发现中序遍历输出的刚好就是数字的序号
    // TreeNode pre_node=new TreeNode(Integer.MIN_VALUE);
    TreeNode pre_node=null;
    //Define two wrong nodes
    TreeNode w1=null;
    TreeNode w2=null;
    public void recoverTree(TreeNode root) {
        in_order_traversal(root);
        if(w1!=null&&w2!=null) {
            w1.val = w1.val + w2.val;
            w2.val=w1.val-w2.val;
            w1.val=w1.val-w2.val;
        }
    }
    public void in_order_traversal(TreeNode root){
        if(root==null){
            return;
        }
        in_order_traversal(root.left);
        //想了很久，W1只能被分配一次，W2可以一直被更改
        //因为题目是两个数字被调换了，所以前面大的数字一定存在问题因为root比
        //pre小的话说明了root和后面一个较大的数字调换了
        //不用if else 因为一回能改变两个
        //1235467这种情况就是两个更改的数字相邻
        //128573
        if(w1==null&&(pre_node==null||root.val<=pre_node.val)){
            w1=pre_node;
        }
        if(w1!=null&&root.val<=pre_node.val){
            w2=root;
        }
        pre_node=root;
        in_order_traversal(root.right);
    }
//    public void recoverTree(TreeNode root) {
//        TreeNode max_node=new TreeNode(Integer.MAX_VALUE);
//        TreeNode min_node=new TreeNode(Integer.MIN_VALUE);
//        limit_value(root,max_node,min_node,null,null,null);
//    }
//    public static void limit_value(TreeNode root,TreeNode max_node,TreeNode min_node,TreeNode w1,TreeNode w2,TreeNode pre_node) {
//        if (w1==null||w2==null) {
//            if (root == null) {
//                return;
//            }
//
//                if (root.val <= min_node.val) {
//                    verdict(w1,w2,root,min_node);
//                }
//                if (root.val >= max_node.val) {
//                    verdict(w1,w2,root,max_node);
//                }
//
//            pre_node=root;
//            limit_value(root.left, root, min_node,w1,w2,pre_node);
//            limit_value(root.right, max_node, root,w1,w2,pre_node);
//        }
//        if(w1!=null&w2!=null) {
//            swap_value(w1, w2);
//        }
//        return;
//
//    }
//    public static void verdict(TreeNode w1,TreeNode w2,TreeNode root,TreeNode extre_node){
//        if(w1==null&&w2==null) {
//            w1 = extre_node;
//            w2 = root;
//        }else{
//            if(w2==w1.left&&root==w1.right||w2==w1.right&&root==w1.left){
//                w1=root;
//            }
//        }
//    }
//    public static void swap_value(TreeNode swap_node,TreeNode extre_node){
//        swap_node.val += extre_node.val;
//        extre_node.val = swap_node.val - extre_node.val;
//        swap_node.val = swap_node.val - extre_node.val;
//    }
}
