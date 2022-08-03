package org.zxz.linkedList;

import java.util.List;

/**
 * @author LEGION
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.add(1);
        listNode.add(2);
        listNode.add(3);
        listNode.add(4);
        listNode.add(5);
        listNode.add(6);
        listNode.add(7);
        listNode.add(8);
        listNode.add(9);
        listNode.add(10);
        ListNode[] listNodes = splitListNodeToParts(listNode.next, 3);
        for (ListNode listNode2 : listNodes) {
            while (listNode2 != null) {
                System.out.print(listNode2.val + " ");
                listNode2 = listNode2.next;
            }
            System.out.println();
        }
    }

    public static ListNode[] splitListNodeToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[0];
        }

        ListNode[] result = new ListNode[k];
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int len = count / k;
        int mod = count % k;
        cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                break;
            }
            result[i] = cur;
            int end = len + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < end - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
    }
}
