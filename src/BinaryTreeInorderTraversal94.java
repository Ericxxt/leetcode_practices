import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
      public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //2019。09。15 leetcode高票方法
    //Runtime: 1 ms, faster than 57.62% of Java online submissions for Binary Tree Inorder Traversal.
  //Memory Usage: 35 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
//    public List<Integer> inorderTraversal(TreeNode root) {
//          List<Integer> list=new ArrayList<>();
//        Stack<TreeNode> stack= new Stack<>();
//        TreeNode current=root;//这个式子是关键，
//        while(current!=null||!stack.isEmpty()){
//            while(current!=null){
//                stack.push(current);
//                current=current.left;
//            }
//            current=stack.pop();//这步保证了这个结点不等于null，是一个叶子结点
//            list.add(current.val);
//            current=current.right;//因为current不等于null，所以right为null时候自动从stack里面pop
//        }
//        return list;
//    }
  public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> list=new ArrayList<>();
      Stack<TreeNode> stack=new Stack<>();
      while(root!=null||!stack.isEmpty()){
          // stack.push(root);
          // root=root.left;// root的前一次循环可能还是null，但是stack不是空的还会执行这一步，所以这里不能使用这条语句
          while(root!=null){
              stack.push(root);
              root=root.left;
          }
          root=stack.pop();
          list.add(root.val);
          root=root.right;

      }
      return list;
  }
}
