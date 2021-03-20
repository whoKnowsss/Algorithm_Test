package util;

import java.util.Random;

/**
 * @Author: 11655
 * @Date: 2021/3/19 22:55
 * @Description:
 */
class ListNodeTemp {
    int val;
    ListNodeTemp next;

    public ListNodeTemp(int vale) {
        this.val = vale;
        this.next = null;
    }

    public void print() {
        System.out.print("[");
        for (ListNodeTemp temp = this; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            System.out.print(temp.next != null ? "->" : "]\n");
        }
    }
}

public class ListNodeTest {

    public static ListNodeTemp traverseDiGui(ListNodeTemp root) {
        if (root == null) return root;
        if (root.next == null) return root;

        ListNodeTemp newHead = traverseDiGui(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }


    static ListNodeTemp successor = null;

    public static ListNodeTemp traverseDiGuiTopK(ListNodeTemp root, int k) {
        if (k == 1) {
            successor = root.next;
            return root;
        }

        ListNodeTemp newHead = traverseDiGuiTopK(root.next, k - 1);
        root.next.next = root;
        root.next = successor;
        return newHead;
    }


    public static ListNodeTemp traverseDiGuiTopAandB(ListNodeTemp root, int from, int to) {
        if (from == 1) {
            return traverseDiGuiTopK(root, to);
        }
        root.next = traverseDiGuiTopAandB(root.next, from - 1, to - 1);
        return root;
    }

    public static ListNodeTemp traverseDieDai(ListNodeTemp root) {
        if (root == null) return root;
        if (root.next == null) return root;

        ListNodeTemp pre, cur, nex;
        for (pre = null, cur = root; cur != null; ) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ListNodeTemp head = new ListNodeTemp(random.nextInt(100));
        ListNodeTemp temp = head;
        for (int i = 0; i < 10; i++) {
            temp.next = new ListNodeTemp(random.nextInt(100));
            temp = temp.next;
        }
        head.print();
        traverseDiGuiTopAandB(head, 4,6).print();
//        traverseDiGuiTopK(head, 4).print();
//        traverseDieDai(head).print();
    }
}
