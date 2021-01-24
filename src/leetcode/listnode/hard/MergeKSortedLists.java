package leetcode.listnode.hard;

import util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedLists {
    public ArrayList<Integer> toString(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ArrayList<Integer> re = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) re.addAll(toString(lists[i]));
        int temp;
        for (int i = 0; i < re.size(); i++) {
            for (int j = i; j < re.size(); j++) {
                if (re.get(i) > re.get(j)) {
                    temp = re.get(i);
                    re.set(i, re.get(j));
                    re.set(j, temp);
                }
            }
        }
        ListNode head = null, tempN = null;
        for (int i = 0; i < re.size(); i++) {
            if (tempN == null) {
                head = new ListNode(re.get(i));
                tempN = head;
            } else {
                tempN.next = new ListNode(re.get(i));
                tempN = tempN.next;
            }
        }
        return head;
    }

}

