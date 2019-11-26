public class SameTree100 {
    //2019。10。29
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
//Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Same Tree.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //这个题目的关键在于要把直到最后一颗右子树都没有出现错误的时候才可以判断为两棵树完全相同
    boolean tf=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(tf){
            if(p==null&&q==null){
            }else if(p==null&&q!=null){
                tf=false;
            }else if(p!=null&&q==null){
                tf=false;
            }else{
                if(p.val==q.val){
                    isSameTree(p.left,q.left);
                    isSameTree(p.right,q.right);
                }else{
                    tf=false;
                }
            }
        }
        return tf;
    }
}
