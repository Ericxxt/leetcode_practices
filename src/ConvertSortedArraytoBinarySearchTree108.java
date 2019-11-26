public class ConvertSortedArraytoBinarySearchTree108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //2019.11.02
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.

    public TreeNode sortedArrayToBST(int[] nums) {
        return recur_gene(nums,0,nums.length-1);
    }
    public TreeNode recur_gene(int[] nums,int start,int end){
        if(start>end||start<0||end>nums.length){
            return null;
        }
        TreeNode node=new TreeNode(nums[(end+start)>>>1]);
        node.left=recur_gene(nums,start,(end+start)/2-1);
        node.right=recur_gene(nums,(end+start)/2+1,end);
        return node;
    }
}
