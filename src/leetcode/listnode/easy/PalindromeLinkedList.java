package leetcode.listnode.easy;

import util.ListNode;

import java.util.ArrayList;

/**
 * @Author: 11655
 * @Date: 2021/01/10
 * @Description: https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    //第一种，用链表的后序遍历
    public static boolean isPalindrome1(ListNode head) {
        left = head;
        return traverse(head);

    }

    public static ListNode left = null;

    public static boolean traverse(ListNode head) {
        if (head == null) return true;
        boolean res = traverse(head.next);
        res = res && (head.val == left.val);
        left = left.next;
        return res;
    }


    //第二种，用hash
    // hash函数是 hash=hash*seed+val
    public static boolean isPalindrome2(ListNode head) {
        long hash1, hash2;
        hash1 = hash2 = 0;
        long seeds = 1;
        long seed = (long) (10e9 + 7);
        for (ListNode temp = head; temp != null; temp = temp.next) {
            hash1 = hash1 * seed + temp.val;
            hash2 = hash2 + seeds * temp.val;
            seeds = seed * seeds;
        }
        return hash1 == hash2;
    }



    public static boolean isPalindrome3(ListNode head) {
        StringBuilder sbPost=new StringBuilder();
        StringBuilder sbPre=new StringBuilder();
        ListNode temp=head;
        while(temp!=null){
            sbPre.append(temp.val);
            temp=temp.next;
        }
        postOrder(head,sbPost);
        return sbPost.toString().equals(sbPre.toString());
    }

    public static  void postOrder(ListNode head,StringBuilder sb){
        if(head !=null){
            postOrder(head.next,sb);
            //do sth.
            sb.append(head.val);
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode temp = node;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(node);
        System.out.println(isPalindrome3(null));
    }
}
