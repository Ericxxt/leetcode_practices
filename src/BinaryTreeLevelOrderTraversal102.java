import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
    //Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
       add_node(root,0,lists);
       return lists;

    }
    public void add_node(TreeNode node,int level,List<List<Integer>> lists){
        if(node==null){
            return;
        }
        if(level==lists.size()){
            lists.add(new ArrayList<>());
        }
            lists.get(level).add(node.val);
        add_node(node.left,level+1,lists);
        add_node(node.right,level+1,lists);
        return;
    }
}
