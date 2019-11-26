public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //preorder = [3,9,20,15,7]
    //inorder = [9,3,15,20,7]

    // ```pre=[3,9,7,4,8,2,1,3]
    // inorder=[7,9,4,3,1,2,8,3]

    //2019/10.30
    //Runtime: 12 ms, faster than 26.29% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    //Memory Usage: 42.5 MB, less than 9.34% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return recur_node(0,0,inorder.length-1,preorder,inorder);

    }
    public TreeNode recur_node(int pre_start,int in_start,int in_end,int[] preorder,int[] inorder){
        if(in_start>in_end||pre_start>preorder.length-1){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pre_start]);
        int currt_index=0;
        for(currt_index=in_start;currt_index<=in_end;currt_index++){
            if(inorder[currt_index]==inorder[pre_start]){
                break;
            }
        }
        root.left=recur_node(pre_start+1,in_start,currt_index-1,preorder,inorder);
        root.right=recur_node(pre_start+currt_index-in_start+1,currt_index+1,in_end,preorder,inorder);
        return root;

    }
}
