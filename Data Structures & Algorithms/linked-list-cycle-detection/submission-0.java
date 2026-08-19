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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast != null) fast = fast.next;
            if (fast != null) fast = fast.next;
            if (slow != null) slow = slow.next;
            if (fast == slow) break;
        }
        return fast == null ? false : true;
    }
}
