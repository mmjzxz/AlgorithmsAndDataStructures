package org.zxz.linkedList;

/**
 * @author LEGION
 * 83 从有序链表中删除重复节点
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.add(1);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(3);
        l1.add(4);
        l1.add(4);
        l1.add(5);
        ListNode listNode = deleteDuplicates(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
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
        return head.next;
    }
}
