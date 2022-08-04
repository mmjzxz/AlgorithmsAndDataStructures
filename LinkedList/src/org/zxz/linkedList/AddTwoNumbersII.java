package org.zxz.linkedList;

import java.util.Stack;

/**
 * @author LEGION
 * 445 链表求和
 * https://leetcode.cn/problems/add-two-numbers-ii/description/
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.add(2);
        l1.add(4);
        l1.add(3);
//        l1.add(7);
//        l1.add(2);
//        l1.add(4);
//        l1.add(3);
        ListNode l2 = new ListNode();
        l2.add(5);
        l2.add(6);
        l2.add(4);
//        l2.add(5);
//        l2.add(6);
//        l2.add(4);
        ListNode listNode = addTwoNumbers(l1.next, l2.next);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode listNode = new ListNode(-1);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = listNode.next;
            listNode.next = node;
            carry = sum / 10;
        }
        return listNode.next;
    }
}
