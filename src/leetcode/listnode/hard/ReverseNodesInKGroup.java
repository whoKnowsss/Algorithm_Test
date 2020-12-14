package leetcode.listnode.hard;

import util.ListNode;

/**
 * @Author: 11655
 * @Date: 2020/12/15
 * @Description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public static ListNode after=null;
    public static ListNode reverseN(ListNode head,int n){
        if(n==1){
            after=head.next;
            return head;
        }
        ListNode temp=reverseN(head.next,n-1);
        head.next.next=head;
        head.next=after;
        return temp;
    }

    public static ListNode reverseBetween(ListNode head,int start,int end){
        if(start==1){
            return reverseN(head,end);
        }
        head.next=reverseBetween(head.next,start-1,end-1);
        return head;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        int num=0;
        ListNode temp=head;
        for(num=1;temp.next!=null;num++,temp=temp.next);
        int group=num/k;
        for(int i=0;i<group;i++){
            head=reverseBetween(head,1+i*k,i*k+k);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode temp = node;
        for (int i = 2; i <=5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(node);
        System.out.println(reverseKGroup(node,3));


    }
}
