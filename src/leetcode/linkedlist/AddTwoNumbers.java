package leetcode.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))),
                new ListNode(9, new ListNode(9, new ListNode(9))));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(-1);
        ListNode result = tempNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;
            tempNode.next = current;
            tempNode = tempNode.next;
        }
        return result.next;
    }
}
