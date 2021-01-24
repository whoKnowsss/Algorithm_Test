package leetcode.binarytree.medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 11655
 * @Date: 2021/01/11 19:58
 * @Description: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    //广度优先遍历
    public Node connect(Node root) {
        if (root == null) return null; //base case
        Queue<Node> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int length = list.size();
            for (int i = 0; i < length; i++) {
                Node temp = list.poll();
                if (i < length - 1)
                    temp.next = list.peek();
                if (temp.left != null) list.offer(temp.left);
                if (temp.right != null) list.offer(temp.right);
            }
        }
        return root;
    }

    //递归
    public Node connect2(Node root) {
        if (root == null) return null;
        if (root.left == null || root.right == null) return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connect2(root.left);
        connect2(root.right);
        return root;
    }


}
