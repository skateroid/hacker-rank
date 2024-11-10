package leetcode.linkedlist;

import java.util.ArrayDeque;

public class ReversedLinkedListII {

    public static void main(String[] args) {
        reverseBetween(new ListNode(3, new ListNode(5)), 1, 2);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tempNode = new ListNode(0);
        ListNode result = tempNode;
        int counter = 1;
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            if (left > counter || right < counter) {
                tempNode.next = head;
                tempNode = tempNode.next;
            } else {
                deque.push(new ListNode(head.val, head.next));
                if (counter == right) {
                    deque.peekLast().next = null;
                    while (!deque.isEmpty()) {
                        tempNode.next = deque.pollFirst();
                        tempNode = tempNode.next;
                    }
                }
            }
            head = head.next;
            counter++;
        }
        return result.next;
    }
}
