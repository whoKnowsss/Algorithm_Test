package leetcode.listnode.medium;

import util.ListNode;

/**
 * @Author: 11655
 * @Date: 2020/12/11 18:18
 * @Description: https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //   1 -> 2 -> 3 -> 4 -> 5
    //
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode startBefore = null, start = null, end = null, endAfter = null, temp = null;
        temp = head;
        for (int i = 1; i <= n; i++) {
            if (i == m - 1) startBefore = temp;
            if (i == m) start = temp;
            if (i == n) end = temp;
            temp = temp.next;
        }
        endAfter = temp;

        ListNode left, cur, right = null;
        for (left = start, cur = left.next, right = cur.next; right != null && right != endAfter; right = right.next) {
            cur.next = left;
            left = cur;
            cur = right;
        }
//        start.next = endAfter;
        cur.next = left;
        if (startBefore == null) {
            head.next = endAfter;
            head = cur;
        } else {
            startBefore.next = cur;
            start.next = endAfter;
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(head.toString());
        System.out.println(reverseBetween(head, 2, 4));
    }
}
