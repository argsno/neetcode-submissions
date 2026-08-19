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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            if (fast != null) fast = fast.next;
            if (fast != null) fast = fast.next;
            if (slow != null) slow = slow.next;
        }
        ListNode middle = reverseList(slow.next);
        
        slow.next = null;
        while (middle != null) {
            ListNode next = head.next;
            head.next = middle;
            middle = middle.next;
            head.next.next = next;
            head = next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
