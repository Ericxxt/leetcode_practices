import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CopListwithRandomPointer138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        //这题浪费了很多时间，一定要记住链表是有顺序的，所以不需要关心random上的东西，按照链表上的来就可以了
        //Runtime: 1 ms, faster than 20.25% of Java online submissions for Copy List with Random Pointer.
        //Memory Usage: 43.2 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
        if(head==null){
            return null;
        }
        Map<Node,Node> map=new HashMap<>();
        Node node=head;
        while(node!=null){
            map.put(node,new Node(node.val));
            node=node.next;
        }
        node=head;
        while(node!=null){
            map.get(node).next=map.get(node.next);
            map.get(node).random=map.get(node.random);
            node=node.next;
        }
       return map.get(head);
    }
    //递归方法好像time limited
//    public Node copyRandomList(Node head) {
//        return recur_copy(head,new HashMap<Integer,Node>());
//    }
//    public Node recur_copy(Node head,HashMap<Integer,Node> map){
//        if(head==null){
//            return head;
//        }
//        if(!map.containsKey(head.val)){
//            map.put(head.val,new Node(head.val));
//            map.get(head.val).next=recur_copy(head.next,map);
//            map.get(head.val).random=recur_copy(head.random,map);
//        }
//        return map.get(head.val);
//    }

}
