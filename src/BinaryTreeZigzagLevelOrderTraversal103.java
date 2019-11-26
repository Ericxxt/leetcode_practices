import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    //2019。10。29
    //Runtime: 1 ms, faster than 98.96% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    //Memory Usage: 36.3 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        HashMap<Integer,Boolean> map=new HashMap<Integer, Boolean>();
        add_zigzag_node(root,0,map,lists);
        return lists;
    }
    public void add_zigzag_node(TreeNode node,int level,HashMap map,List<List<Integer>> lists){
        if(node==null){
            return;
        }
        if(level==map.size()){
            if(map.size()==0){
                map.put(level,true);
            }else {
                map.put(level,(boolean)map.get(level-1)?false:true);
            }
            lists.add(new ArrayList<>());
        }
        if((boolean)map.get(level)) {
            lists.get(level).add(node.val);
        }else {
            //!!!!!!!!!!!!!!!!
            //下面这个方法很关键，选择index并且插入，所以可以选择前插以及后插，十分方便
            lists.get(level).add(0, node.val);
        }
            add_zigzag_node(node.left,level+1,map,lists);
        add_zigzag_node(node.right,level+1,map,lists);
        return;
    }

}
