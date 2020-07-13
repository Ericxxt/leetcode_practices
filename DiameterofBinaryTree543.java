public class DiameterofBinaryTree543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        int[] result=recur_two_val(root);
        return result[1]-1;
    }
    public int[] recur_two_val(TreeNode root){
        if(root==null) return new int[2];
        //val[0] 对应当前树和左右子树中取最长子树的相连，val[1]对应当前树到目前为止的最大值
        int[] vals=new int[2];
        int[] left=recur_two_val(root.left);
        int[] right=recur_two_val(root.right);
        vals[0]=1+Math.max(left[0],right[0]);
        vals[1]=Math.max(1+left[0]+right[0],Math.max(left[1],right[1]));
        return vals;
    }
}
