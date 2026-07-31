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
        ListNode curr = head;

        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        curr = head;
        for (int i = 0; i < size - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return dummy.next;
    }
}
