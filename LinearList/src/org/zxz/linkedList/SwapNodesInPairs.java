package org.zxz.linkedList;

/**
 * @author LEGION
 * 24 交换链表中的相邻结点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        ListNode listNode = swapPairs(head.next);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }

}
