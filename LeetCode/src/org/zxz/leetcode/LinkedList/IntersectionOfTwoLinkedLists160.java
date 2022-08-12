package org.zxz.leetcode.LinkedList;

/**
 * @author LEGION
 * 160相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists
 */
public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.add(1);
        headA.add(8);
        headA.add(4);
        headA.add(5);
        ListNode headB = new ListNode(5);
        headB.add(6);
        headB.add(1);
        headB.add(8);
        headB.add(4);
        headB.add(5);
        IntersectionOfTwoLinkedLists160 intersectionOfTwoLinkedLists160 = new IntersectionOfTwoLinkedLists160();
        ListNode node = intersectionOfTwoLinkedLists160.getIntersectionNode(headA, headB);
        System.out.println(node.val);
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode slow = headA, fast = headB;
        while (slow != fast) {
            slow = slow == null ? headB : slow.next;
            fast = fast == null ? headA : fast.next;
        }
        return slow;
    }
}
