package util;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @Author: 11655
 * @Date: 2020/11/22 19:55
 * @Description: 链表工具
 */
public class ListNode implements Cloneable {
    int val;
    ListNode next;

    ListNode(int val) {
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

    //遍历 反转 返回头节点
    public static ListNode traverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left, current, right = null;
        for (left = head, current = head.next, right = current.next; right != null; right = right.next) {
            current.next = left;
            left = current;
            current = right;
        }
        current.next = left;
        head.next = null;
        return current;
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

            System.out.println(traverse(clonedTemp));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
