package org.zxz.linkedList;

/**
 * @author LEGION
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class IntersectionOfTwoLinkedLists {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node p1 = headA;
        Node p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
