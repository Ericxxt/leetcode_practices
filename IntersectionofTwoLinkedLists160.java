
public class IntersectionofTwoLinkedLists160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node_a = headA;
        ListNode node_b = headB;
        //不需要另外考虑headA和headB没有关联的情况因为走完两边之后两者变为null所以相等
        //这个题目的原理就是相遇之后的距离是相同的，
        //所以只考虑相遇之前，即使步数不同node走了距离小的一边之后还需要另一边
        //那么两个node走的距离都是一样的，所以他们肯定会相遇
        //这个方法实在是太巧妙了
        while (node_a != node_b) {
            node_a = node_a == null ? headB : node_a.next;
            node_b = node_b == null ? headA : node_b.next;
        }
        return node_a;
    }
}
