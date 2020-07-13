import java.util.List;

public class MaximumDepthofN_aryTree559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    int depth=0;
    public int maxDepth(Node root) {
        recur_tee(root,1);
               return depth;
    }
    public void recur_tee(Node root,int deep){
        if(root==null) return;
        for(Node node: root.children){
            recur_tee(node,deep+1);
        }
        depth=Math.max(depth,deep);
    }
}
