import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    boolean tf=true;
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        //right_left_check 左子数的右结点需要和前结点比较
//        //右子数的左结点需要和前结点比较
//        //这里用当前结点值和前结点比较即可得出是右还是左
//        return valid_recursion(root,new ArrayList<Integer>());
//    }
//
//        public boolean valid_recursion(TreeNode root, List<Integer> lists) {
//        if (tf) {
//            if (root == null) {
//                return tf;
//            }
//            List<Integer> single_list=new ArrayList<>(lists);
//            single_list.add(root.val);
//            if (root.left != null) {
//                //如果是第一次那么不需要和先前的结点值进行比较
//                if (lists.get(lists.size()-1) >= root.val) {
//                    if (root.left.val >= root.val) {
//                        tf = false;
//                    }
//                } else {
//                    if (root.left.val >= root.val) {
//                        System.out.println("in");
//                        tf = false;
//                    }
//                    for(int num :lists){
//                        if(root.left.val<=num){
//                            tf = false;
//                        }
//                    }
//                }
//            }
//            if (root.right != null) {
////                System.out.println("in");
//                if (lists.get(lists.size()-1) <= root.val) {
//                    if (root.right.val <= root.val) {
//                        tf = false;
//                    }
//                } else {
//                    if (root.right.val <= root.val) {
////                    System.out.println("root.right.val:" + root.right.val + ",root.val:" + root.val);
//                        tf = false;
//                    }
//                    for(int num :lists){
//                        if(root.right.val>=num){
//                            tf = false;
//                        }
//                    }
//                }
//            }
//            valid_recursion(root.left,single_list);
//            single_list.remove(single_list.size()-1);
//            System.out.println("list1:"+lists.toString());
//            valid_recursion(root.right,single_list);
//            single_list.remove(single_list.size()-1);
//            System.out.println("list2:"+lists.toString());
//
//        }
//        return tf;
//    }
    public boolean isValidBST(TreeNode root) {
        return recursion_bts(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean recursion_bts(TreeNode root,long min_num,long max_num){
        if(root==null){
            return true;
        }
        if(root.val<=min_num||root.val>=max_num){
            return false;
        }
        return recursion_bts(root.left,min_num,root.val)&&recursion_bts(root.right,root.val,max_num);

    }
}

