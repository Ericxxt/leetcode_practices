import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node =root;
        stack.push(node);
        while (!stack.isEmpty()){

        }
        return null;
    }
}
