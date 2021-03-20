package leetcode.binarytree.medium;


import util.TreeNode;

import java.util.*;

/**
 * @Author: 11655
 * @Date: 2021/1/25 0:43
 * @Description: https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class findDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    public HashMap<StringBuilder, Integer> map;
    public List<TreeNode> list;

    public StringBuilder traverse(TreeNode head) {
        if (head == null) return new StringBuilder("#");
        StringBuilder left = traverse(head.left);
        StringBuilder right = traverse(head.right);
        left.append(",").append(right).append(",").append(head.val);
        map.put(left, map.getOrDefault(left, 0) + 1);
        if(map.get(left)==2)
            list.add(head);
        return left;
    }

}
