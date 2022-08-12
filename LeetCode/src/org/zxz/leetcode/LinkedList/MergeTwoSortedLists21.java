package org.zxz.leetcode.LinkedList;

import java.util.Random;

/**
 * @author LEGION
 * 21 归并两个有序的链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        int random_num = new Random().nextInt(RandomNum.RANDOM_PARAM) + RandomNum.RANDOM_PARAM;
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        for (int i = 0; i < random_num; i++) {
            l1 = l1.add(i * 3);
            l2 = l2.add(i + 1);
        }
        ListNode listNode = mergeTwoLists(l1.next, l2.next);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * 双指针法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    /**
     * 递归法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }
}
