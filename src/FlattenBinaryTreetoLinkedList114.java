import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 36 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.

    TreeNode prev=null;
    //这种方法实在是太强了，真的需要思考很久才能消化，领悟到它的精髓
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
        return;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.

    //这个题目不能占据额外的空间，所以需要重新写代码
//        public void flatten(TreeNode root) {
//            if(root==null){
//                return;
//            }
//            flatten(root.left);
//            flatten(root.right);
//            if(root.left==null){
//                return;
//            }
//            //找到左边的叶子结点的最后一个结点
//            TreeNode node=root.left;
//            //这时候只需要找到这个最后的左边叶子结点的右边结点了
//            while (node.right!=null){
//                node=node.right;
//            }
//            node.right=root.right;
//            root.right=root.left;
//            //下面的这步很关键，root的left需要设置为null
//            root.left=null;
//            return;
//        }
//    public void flatten(TreeNode root) {
//            List<Integer> list=new ArrayList<>();
////            System.out.println(list.toString());
//            in_order_recur(root,list);
//            root.left=null;
//            root.right=null;
//            for(int i:list){
//                root=new TreeNode(i);
//                System.out.println("root:"+root.val
//                );
//                root.right=null;
//                root=root.right;
//            }
//    }
//    public void in_order_recur(TreeNode root, List<Integer> list){
//        if(root==null){
//            return;
//        }
//        list.add(root.val);
//        in_order_recur(root.left,list);
//        in_order_recur(root.right,list);
//        return;
//    }
    //    public void gene(int i,TreeNode root,List<Integer> list){
//        if(list.size()>i){
//            root=new TreeNode(list.get(i));
//        }
//        gene(i+1,root.right,list);
//        return;
//    }

//    public TreeNode in_order_recur(TreeNode root,TreeNode new_root){
//        if(root==null){
//            return root;
//        }
//        new_root=new TreeNode(root.val);
//        in_order_recur(root.left,new_root.right);
//        if(new_root.right==null){
//            in_order_recur(root.right,new_root.right);
//        }else{
//                TreeNode recur_root=new_root;
//                while(recur_root.right!=null){
//                    recur_root=recur_root.right;
//                }
//                recur_root.right=in_order_recur(root.right,recur_root.right);
//        }
//        return new_root;
//    }

}
