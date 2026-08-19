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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (n-- > 0) {
            curr = curr.next;
        }

        ListNode removed = dummy;
        while (curr.next != null) {
            curr = curr.next;
            removed = removed.next;
        }
        removed.next = removed.next.next;
        return dummy.next;
    }
}
