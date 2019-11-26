import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_2_107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019.10.30
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
    //Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new LinkedList<>();
        traversal(lists,root,0);
        return lists;
    }
    public void traversal(List<List<Integer>> lists,TreeNode node,int level){
        if(node==null){
            return;
        }
        if(level==lists.size()){
            lists.add(0,new ArrayList<>());
        }
        lists.get(lists.size()-level-1).add(node.val);
        traversal(lists,node.left,level+1);
        traversal(lists,node.right,level+1);
        return;
    }
}
