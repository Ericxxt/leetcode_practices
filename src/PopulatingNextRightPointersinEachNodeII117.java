public class PopulatingNextRightPointersinEachNodeII117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //2019.11.20 真的不知道为什么用116的解法就不行，然后看了视频使用head和prev

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
    //Memory Usage: 55.1 MB, less than 9.52% of Java online submissions for Populating Next Right Pointers in Each Node II.
    public Node connect(Node root) {
        //head就是每一层的头结点
        Node head_node = null;
        Node cur_node = root;
        //prev就是每个需要连接到当前结点的前面的结点
        Node pre_node = null;
        while (cur_node != null) {
            while (cur_node != null) {
                if (cur_node.left != null) {
                    if (head_node == null) {
                        head_node = cur_node.left;
                        pre_node = cur_node.left;
                    } else {
                        pre_node.next = cur_node.left;
                        pre_node = pre_node.next;
                    }
                }
                if (cur_node.right != null) {
                    if (head_node == null) {
                        head_node = cur_node.right;
                        pre_node = cur_node.right;
                    } else {
                        pre_node.next = cur_node.right;
                        pre_node = pre_node.next;
                    }
                }
                cur_node = cur_node.next;
            }
            //cur_node设置成下一层的头结点，因此可以继续循环118. Pascal's Trianglez
            cur_node = head_node;
            head_node = null;
            pre_node = null;
        }
        return root;
    }
}

//    public Node connect(Node root) {
//        Node start_node=root;
//        while(start_node!=null){
//            Node cur_node=start_node;
//            while (cur_node!=null){
//                if(cur_node.left!=null){
//                    if(cur_node.right!=null){
//                        cur_node.left.next=cur_node.right;
//                    }else if(cur_node.next!=null){
//                        cur_node.left.next=cur_node.next.left==null?cur_node.next.right:cur_node.next.left;
//                    }
//                }
//                if(cur_node.right!=null){
//                    if(cur_node.next!=null){
//                        cur_node.right.next=cur_node.next.left==null?cur_node.next.right:cur_node.next.left;
//                    }
//                }
//                cur_node=cur_node.next;
//            }
//            if(start_node.left!=null){
//                start_node=start_node.left;
//            }else if(start_node.right!=null){
//                start_node=start_node.right;
//            }else{
//                if(start_node.next!=null) {
//                    start_node = start_node.next.left == null ? start_node.next.right:start_node.next.left;
//                }else{
//                    start_node=null;
//                }
//            }
//        }
//        return root;
//    }


