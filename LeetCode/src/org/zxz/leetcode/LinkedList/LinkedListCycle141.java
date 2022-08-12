package org.zxz.leetcode.LinkedList;

import java.util.HashSet;

/**
 * @author LEGION
 * 141.环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class LinkedListCycle141 {
    public static void main(String[] args) {
        LinkedListCycle141 linkedListCycle141 = new LinkedListCycle141();
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
        boolean has = linkedListCycle141.hasCycle(head);
        System.out.println(has);
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    private boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    private boolean hasCycleDoublePointer(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
