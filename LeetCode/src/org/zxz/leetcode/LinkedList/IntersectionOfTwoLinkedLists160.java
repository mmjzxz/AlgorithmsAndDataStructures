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
        ListNode headB = new ListNode(5);
        headB.add(6);
        headB.add(1);
        ListNode intersection = new ListNode(8);
        intersection.add(4);
        intersection.add(5);
        headA.add(intersection);
        headB.add(intersection);
        IntersectionOfTwoLinkedLists160 intersectionOfTwoLinkedLists160 = new IntersectionOfTwoLinkedLists160();
        ListNode node = intersectionOfTwoLinkedLists160.getIntersectionNode(headA, headB);
        System.out.println(node == null ? "null" : node.val);
    }

    /**
     * 双指针
     * slow: 4->1->8->4->5->null->5->6->1->8->4->5->null
     * fast: 5->6->1->8->4->5->null->4->1->8->4->5->null
     *
     * @param headA
     * @param headB
     * @return
     */
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

    /**
     * @param headA
     * @param headB
     * @return
     */
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode longHead = lenA > lenB ? headA : headB;
        ListNode shortHead = lenA > lenB ? headB : headA;
        int diff = Math.abs(lenA - lenB);
        for (int i = 0; i < diff; i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
