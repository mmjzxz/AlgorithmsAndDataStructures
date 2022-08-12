package org.zxz.leetcode.LinkedList;

/**
 * @author LEGION
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList83 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList83 removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList83();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = removeDuplicatesFromSortedList.deleteDuplicatesRecursive(head);//removeDuplicatesFromSortedList.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode pre = head;
//        ListNode next = head.next;
//        while (next != null) {
//            if (pre.val != next.val) {
//                pre.next = next;
//                pre = pre.next;
//            }
//            next = next.next;
//        }
//        pre.next = null;
//        return head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素-递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesRecursive(head.next);
        if (head.val == head.next.val) {
            return head.next;
        }
        return head;
    }
}
