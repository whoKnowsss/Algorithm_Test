package leetcode.listnode.hard;

import util.ListNode;

/**
 * @Author: 11655
 * @Date: 2020/12/15
 * @Description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public static ListNode successor = null;

    public static ListNode reverseN(ListNode head, ListNode right) {
        if (head.next == right) {
            successor = head.next;
            return head;
        }
        ListNode after = reverseN(head.next, right);
        head.next.next = head;
        head.next = successor;
        return after;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) return head;
            right = right.next;
        }
        ListNode newHead = reverseN(head, right);
        head.next = reverseKGroup(right, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode temp = node;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(node);
        System.out.println(reverseKGroup(node, 2));


    }
}
