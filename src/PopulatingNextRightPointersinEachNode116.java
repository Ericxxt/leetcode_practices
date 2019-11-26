public class PopulatingNextRightPointersinEachNode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //下面的方法是看答案学习的，这个算法很简练，很强
    //2019。11。17
    public Node connect(Node root) {
        Node start_node=root;
        while(start_node!=null){
            Node cur_node=start_node;
            //下面的cur_node是为了改变同一层级的node
            while(cur_node!=null){
                if(cur_node.left!=null) {
                    cur_node.left.next = cur_node.right;
                }
                if(cur_node.right!=null&&cur_node.next!=null){
                    cur_node.right.next=cur_node.next.left;
                }
                cur_node=cur_node.next;
            }
            //start_node是为了改变下一个层级的node
            start_node=start_node.left;
        }
        return root;
    }

}
