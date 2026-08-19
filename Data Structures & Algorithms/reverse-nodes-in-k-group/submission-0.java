/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        head = dummy;
        ListNode tail = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode nextHead = head.next;
            reverseList(head.next, tail);
            head.next.next = next;
            head.next = tail;

            head = nextHead;
            tail = nextHead;
        }
    }

    private void reverseList(ListNode head, ListNode tail) {
        if (head == tail) {
            return;
        }
        reverseList(head.next, tail);
        head.next.next = head;
        head.next = null;
    }
}
