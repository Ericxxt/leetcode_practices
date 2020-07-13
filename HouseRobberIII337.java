import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII337 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int rob(TreeNode root) {
        int[] result=res(root);
        return Math.max(result[0],result[1]);
    }
    public int[] res(TreeNode root){
        if(root==null) return new int[2];
        int[] left_num=res(root.left);
        int[] right_num=res(root.right);
        int[] res=new int[2];
        res[0]=Math.max(left_num[0],left_num[1])+Math.max(right_num[0],right_num[1]);
        res[1]=root.val+left_num[0]+right_num[0];
        return res;
    }

  //第三种终极高票方法
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        //left[1],right[1]才可能是当前root的下一层的值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //如果是res[1只会与当前值隔代]
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    //加入map后的效果
    public int rob(TreeNode root) {
        return recur_map(root,new HashMap<TreeNode,Integer>());
    }
    public int recur_map(TreeNode root, Map<TreeNode,Integer> map){
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int left_num=0;
        int right_num=0;
        if(root.left!=null){
            left_num=recur_map(root.left.left,map)+recur_map(root.left.right,map);
        }
        if(root.right!=null){
            right_num=recur_map(root.right.left,map)+recur_map(root.right.right,map);
        }
        //return rob(root.left)+rob(root.right)保证了隔代，也就是这层的root.val不会被输入
        map.put(root,Math.max(left_num+right_num+root.val,recur_map(root.left,map)+recur_map(root.right,map)));
        return map.get(root);
    }
    //下面的递归方法虽然很简洁，但是每次rob的时候都会有重复的元素很麻烦所以需要加入map
    public int rob(TreeNode root) {
          if(root==null) return 0;
          int left_num=0;
          int right_num=0;
          if(root.left!=null){
              left_num=rob(root.left.left)+rob(root.left.right);
          }
          if(root.right!=null){
              right_num=rob(root.right.left)+rob(root.right.right);
          }
          //return rob(root.left)+rob(root.right)保证了隔代，也就是这层的root.val不会被输入
          return Math.max(left_num+right_num+root.val,rob(root.left)+rob(root.right));
    }
    //   public int rob(TreeNode root) {
    //          if(root==null) return 0;
    // 下面只定义一个变量
    //          int val=0;
    //          if(root.left!=null){
    //              val+=rob(root.left.left)+rob(root.left.right);
    //          }
    //          if(root.right!=null){
    //              val+=rob(root.right.left)+rob(root.right.right);
    //          }
    //          return Math.max(val+root.val,rob(root.left)+rob(root.right));
    //    }
  //下面是自己想的方法，思路就是最大值不是1,3,5,7跳就是2，4，6
    //但也可能是1，4，6这样所以不对
//    public int rob(TreeNode root) {
//        if(root==null) return 0;
//        int first_num=rob(root.left);
//        int second_num=rob(root.right);
//        return Math.max(recursion_rob(root),recursion_rob(root.left)+recursion_rob(root.right));
//    }
//    public int recursion_rob(TreeNode root){
//        if(root==null) return 0;
//        int left_num=0;
//        int right_num=0;
//        if(root.left!=null) {
//            left_num = recursion_rob(root.left.left)+recursion_rob(root.left.right);
//
//        }
//        if(root.right!=null) {
//            right_num = recursion_rob(root.right.left)+recursion_rob(root.right.right);
//        }
//        return root.val+left_num+right_num;
//    }
}
