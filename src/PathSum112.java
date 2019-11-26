public class PathSum112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019/11/11
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    //Memory Usage: 37.9 MB, less than 89.41% of Java online submissions for Path Sum.
    public boolean hasPathSum(TreeNode root, int sum) {
        recur(root,sum,0);
        return tf;
        }
    boolean tf=false;
    public void recur(TreeNode root,int sum,int cur_num){
        if (root == null){
            return;
        }
        if(!tf) {
            cur_num+=root.val;
            //判断语句不能加在root判断null的前面，因为必须是roo到叶子结点
            if(cur_num==sum&&root.left==null&&root.right==null){
                tf=true;
            }
            recur(root.left,sum,cur_num);
            recur(root.right,sum,cur_num);
        }
        return;
    }
}
