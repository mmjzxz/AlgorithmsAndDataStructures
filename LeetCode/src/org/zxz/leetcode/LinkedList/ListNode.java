package org.zxz.leetcode.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //尾插法
    public ListNode add(int val) {
        ListNode node = new ListNode(val);
        if (this.next == null) {
            this.next = node;
        } else {
            ListNode p = this;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        return this;
    }
}
