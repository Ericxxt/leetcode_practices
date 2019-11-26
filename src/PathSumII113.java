import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019/11/11
    //Runtime: 2 ms, faster than 35.87% of Java online submissions for Path Sum II.
    //Memory Usage: 40 MB, less than 18.18% of Java online submissions for Path Sum II.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists=new ArrayList<>();
        list_recur(root,sum,0,lists,new ArrayList<>());
        return lists;
    }
    public void list_recur(TreeNode root,int sum,int cur_num,List<List<Integer>> lists,List<Integer> list){
        System.out.println("list:"+list.toString());
        if(root==null){
            return;
        }
        cur_num+=root.val;
        list.add(root.val);
        if(cur_num==sum&&root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }
        list_recur(root.left,sum,cur_num,lists,new ArrayList<>(list));
        list_recur(root.right,sum,cur_num,lists,new ArrayList<>(list));
        return;
    }

}
