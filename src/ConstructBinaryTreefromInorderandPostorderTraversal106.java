public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019/10/30
    //Runtime: 7 ms, faster than 37.17% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    //Memory Usage: 39.6 MB, less than 21.82% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.

    //inorder = [9,3,15,20,7]
    //postorder = [9,15,7,20,3]
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
            return null;
        }
        return recur_tree(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    public  TreeNode recur_tree(int post_start,int in_start,int in_end,int[] inorder,int[] postorder){
        if(in_start>in_end||post_start<0){
            return null;
        }
        System.out.println(post_start);
        TreeNode node=new TreeNode(postorder[post_start]);
        int curret=0;
        for(curret=in_start;curret<=in_end;curret++){
            if(inorder[curret]==node.val){
                break;
            }
        }
        node.right=recur_tree(post_start-1,curret+1,in_end,inorder,postorder);
        node.left=recur_tree(post_start-in_end+curret-1,in_start,curret-1,inorder,postorder);
        return node;
    }
}
