package leetcode.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);
        ListNode result = tempNode;
        while (list1 != null || list2 != null) {
            int firstVal = 101;
            int secondVal = 101;
            if (list1 != null) {
                firstVal = list1.val;
            }
            if (list2 != null) {
                secondVal = list2.val;
            }
            if (firstVal <= secondVal) {
                list1 = list1.next;
                tempNode.next = new ListNode(firstVal);
            } else {
                list2 = list2.next;
                tempNode.next = new ListNode(secondVal);
            }
            tempNode = tempNode.next;
        }
        return result.next;
    }
}
