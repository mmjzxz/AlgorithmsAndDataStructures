package org.zxz.linkedList;

/**
 * @author LEGION
 * 328 链表元素按奇偶聚集
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);
        head.add(7);
        head.add(8);
        head.add(9);
        head.add(10);
        ListNode result = oddEvenList(head.next);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
