public class MinimumDepthofBinaryTree111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //网上解法
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
    //Memory Usage: 38.5 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //从下往上叠加，如果一棵为null，那么另一个不为的就是1
        //下面的+1其实是对当前的root层级+1而不是为了left或者right
        //(left==0||right==0)?left+right+1 这步实在神奇
       return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }
    //自己居然做不出来！！！！
//    public int recur(TreeNode root,int level){
//        if(root==null){
//            return level;
//        }
//
//        return level;
//    }
}
