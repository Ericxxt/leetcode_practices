import java.util.ArrayList;
import java.util.List;

public class PathSumIII437 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //方法一，dfs
    //这个题目的dfs思想好好理解
    public int pathSum(TreeNode root, int sum) {
          if(root==null) return 0;
          int paths=0;
          //下面这步就是精髓，既是当前root的dfs递归，也是左右子树重新赋target所要求的递归
          paths+=dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
          return paths;
    }
    public int dfs(TreeNode root, int target){
          int paths=0;
        if(root==null) return 0;
        if(root.val==target) paths++;
        paths+=dfs(root.left,target-root.val)+dfs(root.right,target-root.val);
        return paths;
    }
//    public int pathSum(TreeNode root, int sum) {
//        int paths=0;
//
//    }
//    public void recur_count(TreeNode root, int count, List<Integer> list,int sum){
//
//    }
}
