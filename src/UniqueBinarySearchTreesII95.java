import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<TreeNode> generateTrees(int n){
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return recursionNode(1,n);
    }
    public List<TreeNode> recursionNode(int start, int end){
        //最终返回的就是第一次的循环1-n的list，是最大的tree
        //其他递归返回的list都化作left或者right
        List<TreeNode> nodes=new ArrayList<TreeNode>();
        if(start>end){
            nodes.add(null);
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left_nodes=recursionNode(start,i-1);
            List<TreeNode> right_nodes=recursionNode(i+1,end);
            for(TreeNode left :left_nodes){
                for(TreeNode right: right_nodes){
                    TreeNode tn=new TreeNode(i);
                    tn.left=left;
                    tn.right=right;
                    nodes.add(tn);
                }
            }
        }
        return nodes;
    }
}
