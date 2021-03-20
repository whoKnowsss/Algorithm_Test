package util;

import com.sun.deploy.panel.ITreeNode;
import netscape.security.UserTarget;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: 11655
 * @Date: 2020/11/22 19:56
 * @Description:二叉树
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //先序遍历
    public static TreeNode preOrder(TreeNode root) {
        if (root == null) return null; //base case
        System.out.println(root.val); //do sth.
        preOrder(root.left);
        preOrder(root.right);
        return root;
    }

    //中序遍历
    public static TreeNode inOrder(TreeNode root) {
        if (root == null) return null; //base case
        inOrder(root.left);
        System.out.println(root.val); //do sth.
        inOrder(root.right);
        return root;
    }

    //后序遍历
    public static TreeNode postOrder(TreeNode root) {
        if (root == null) return null; //base case
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val); //do sth.
        return root;
    }

    //层次遍历,广度优先遍历
    public static void levelOrder(TreeNode root) {
        if (root == null) return; //base case
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (list.size() != 0) {
            TreeNode temp = list.poll();
            System.out.println(temp.val); //do sth.
            if (temp.left != null) list.offer(temp.left);
            if (temp.right != null) list.offer(temp.right);
        }
    }

    //深度优先遍历,先序遍历
    public static void depthOrder(TreeNode root) {
        if (root == null) return; //base case
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode temp = stack.pop();
            System.out.println(temp.val); //do sth.
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    //二叉树先序遍历，非递归
    //根->左->右
    public static void preOrderFei(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            //do sth.
            System.out.print(temp.val + "->");

            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        System.out.println("");
    }

    //二叉树中序遍历，非递归
    //左->根->右
    public static void inOrderFei(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                //左侧已经遍历完毕，开始根
                //do sth.
                temp = stack.pop();
                System.out.print(temp.val + "->");
                temp = temp.right;
            }
        }
        System.out.println("");
    }




    //二叉树后序遍历，非递归
    //左->右->根
    public static void postOrderFei(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode temp = null;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) stack1.push(temp.left);
            if (temp.right != null) stack1.push(temp.right);
        }
        while (!stack2.isEmpty()) {
            temp = stack2.pop();
            System.out.print(temp.val + "->");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        //先 1 3 4 9 2 3 2
        preOrderFei(root);
        //中 4 3 9 1 3 2 2
        inOrderFei(root);
        //后 4 9 3 3 2 2 1
        postOrderFei(root);
    }
}
