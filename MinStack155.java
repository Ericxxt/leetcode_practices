import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinStack155 {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    //下面是leetcode上我认为的最佳解法
    //class MinStack {
    //    private Node head;
    //
    //    public void push(int x) {
    //        if(head == null)
    //            head = new Node(x, x);
    //        else
    //            head = new Node(x, Math.min(x, head.min), head);
    //    }
    //
    //    public void pop() {
    //        head = head.next;
    //    }
    //
    //    public int top() {
    //        return head.val;
    //    }
    //
    //    public int getMin() {
    //        return head.min;
    //    }
    //
    //    private class Node {
    //        int val;
    //        int min;
    //        Node next;
    //
    //        private Node(int val, int min) {
    //            this(val, min, null);
    //        }
    //
    //        private Node(int val, int min, Node next) {
    //            this.val = val;
    //            this.min = min;
    //            this.next = next;
    //        }
    //    }
    //}
    class MinStack {

        /** initialize your data structure here. */
        Integer top;
        List<Integer> list;
        public MinStack() {
            list=new ArrayList<>();
        }
        public void push(int x) {
            list.add(x);
            this.top=x;
        }
        public void pop() {
            if(list.size()>0) {
                list.remove(list.size() - 1);
            }
            top=list.size()>0?list.get(list.size()-1):null;
        }
        public int top() {
            return top;
        }
        public int getMin() {
            Integer min=list.size()>0?list.get(0):null;
            for(int i:list){
                min=Math.min(min,i);
            }
            return min;
        }
    }
}
