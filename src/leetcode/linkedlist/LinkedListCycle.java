package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }




    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
