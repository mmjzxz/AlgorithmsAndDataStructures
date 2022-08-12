package org.zxz.leetcode.LinkedList;

/**
 * @author LEGION
 * 142 环形链表
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle142 {
    public static void main(String[] args) {
        LinkedListCycle142 linkedListCycle142 = new LinkedListCycle142();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode node = linkedListCycle142.detectCycle(head);
        System.out.println(node.val);
    }

    private ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
