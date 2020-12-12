package util;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @Author: 11655
 * @Date: 2020/11/22 19:55
 * @Description: 链表工具
 */
public class ListNode implements Cloneable {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode temp = this.next;
        while (temp != null) {
            sb.append("->").append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        obj = super.clone();
        ListNode temp = (ListNode) obj;
        if (temp.next != null)
            temp.next = (ListNode) next.clone();
        return temp;
    }

    //   1 -> 2 -> 3 -> 4 -> 5
    //通过遍历 反转 返回头节点
    public static ListNode reverseTraverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = null, current = null, right = null;
        for (left = head, current = head.next, right = current.next; right != null; right = right.next) {
            current.next = left;
            left = current;
            current = right;
        }
        head.next = null;
        current.next = left;
        return current;
    }


    //   1 -> 2 -> 3 -> 4 -> 5
    //通过递归 反转 返回头节点
    public static ListNode reverseRecursive(ListNode head) {
        if (head.next == null) return head;  //base case
        ListNode last = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    //   1 -> 2 -> 3 -> 4 -> 5
    //通过递归 反转 返回头节点   翻转链表前n个节点
    ListNode temp = null;

    public static ListNode reverseRecursive(ListNode head, int n) {
        if (head.next == null || n == 1) return head;  //base case
        ListNode last = reverseRecursive(head.next, n - 1);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);

        ListNode temp = node;
        for (int i = 0; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(node);

        try {
            ListNode clonedTemp = (ListNode) node.clone();
            clonedTemp.next.val = 100;
            System.out.println(clonedTemp);
            System.out.println(node);

            System.out.println(reverseRecursive(clonedTemp));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
