package org.zxz.leetcode.LinkedList;

/**
 * @author LEGION
 * 206. Reverse Linked List
 * https://leetcode.cn/problems/reverse-linked-list
 */

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ReverseLinkedListListNode head = new ReverseLinkedListListNode(1);
        ReverseLinkedListListNode node1 = head;
        for (int i = 0; i < 5; i++) {
            node1.next = new ReverseLinkedListListNode(i + 2);
            node1 = node1.next;
        }
        ReverseLinkedListListNode reverseLinkedListListNode = reverseList(head);
        while (reverseLinkedListListNode != null) {
            System.out.println(reverseLinkedListListNode.val);
            reverseLinkedListListNode = reverseLinkedListListNode.next;
        }
    }
    public static ReverseLinkedListListNode reverseList(ReverseLinkedListListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ReverseLinkedListListNode node = new ReverseLinkedListListNode(-1);
        while (head != null) {
            ReverseLinkedListListNode next = head.next;
            head.next = node.next;
            node.next = head;
            head = next;
        }
        return node.next;
    }
}

class ReverseLinkedListListNode {
    int val;
    ReverseLinkedListListNode next;

    ReverseLinkedListListNode() {
    }

    ReverseLinkedListListNode(int val) {
        this.val = val;
    }

    ReverseLinkedListListNode(int val, ReverseLinkedListListNode next) {
        this.val = val;
        this.next = next;
    }
}
