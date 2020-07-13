import java.util.*;

public class CloneGraph133 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
//        Runtime: 28 ms, faster than 35.31% of Java online submissions for Clone Graph.
//        Memory Usage: 38.8 MB, less than 5.88% of Java online submissions for Clone Graph.
        //2020/2/12
        //自己又重新思考了一下写了下面的方法
        //和原来的相比差不多
        public Node cloneGraph(Node node) {
            Map<Integer,Node> map=new HashMap<>();
            return recur_clone(node,map);
        }
        public Node recur_clone(Node node,Map<Integer,Node> map){
            if(node==null)return null;
            if(!map.containsKey(node.val)){
                map.put(node.val,new Node(node.val,new ArrayList<>()));
                for(Node single_node : node.neighbors){
                    recur_clone(single_node,map);
                    map.get(node.val).neighbors.add(map.get(single_node.val));
                }
            }
            return map.get(node.val);
        }
//        public Node cloneGraph(Node node) {
//            if(node==null){
//                return null;
//            }
//            //为什么适合使用hashmap因为map一一对应， 一个节点对应想要复制的节点
//            Map<Integer,Node> map=new HashMap<>();
//            map.put(node.val,new Node(node.val,new ArrayList<>()));
//            Queue<Node> queue=new LinkedList<>();
//            queue.offer(node);
//            while(!queue.isEmpty()){
//                //弹出队列中的node
//                Node cur_node=queue.poll();
//                //对一个node进行遍历，为每一个没访问过的节点创建新node和空neignbors
//                for(Node single_node : cur_node.neighbors){
//                    if(!map.containsKey(single_node.val)){
//                        map.put(single_node.val,new Node(single_node.val,new ArrayList<>()));
//                        //将新访问的节点添加到队列当中等待判断
//                        queue.offer(single_node);
//                    }
//                    //这里的single_node还是第一个节点的neibors并不是深拷贝
//                    map.get(cur_node.val).neighbors.add(map.get(single_node.val));
//                }
//            }
//            return map.get(node.val);
//        }
    }
}
