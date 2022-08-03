package org.zxz.linkedList;

/**
 * @author LEGION
 * 19 删除链表的倒数第 n 个节点
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        ListNode listNode = removeNthFromEnd(head.next, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (n-- > 0) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
