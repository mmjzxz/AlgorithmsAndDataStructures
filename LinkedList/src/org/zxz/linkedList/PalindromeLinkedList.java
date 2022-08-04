package org.zxz.linkedList;

import java.util.Stack;

/**
 * @author LEGION
 * 234 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(3);
        head.add(1);
        boolean isPalindrome = isPalindrome(head.next);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        fast = head;
        int num = 0;
        while (num < count / 2) {
            stack.push(fast.val);
            fast = fast.next;
            num++;
        }
        if (count % 2 == 1) {
            fast = fast.next;
        }
        while (fast != null) {
            if (stack.pop() != fast.val) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 偶数节点，让 slow 指向下一个节点
        if (fast != null){
            slow = slow.next;
        }
        // 切成两个链表
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

}
