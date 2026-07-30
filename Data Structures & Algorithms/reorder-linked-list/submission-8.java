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
    private ListNode findMiddle(final ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode mid) {
        ListNode prev = null;
        ListNode curr = mid;

        while (curr != null) {
            final ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;

        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        ListNode curr1 = head;
        ListNode curr2 = secondHalf;
        int count = 1;
        while (curr1 != null && curr2 != null) {
            if (count % 2 != 0) {
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr = curr.next;
                curr2 = curr2.next;
            }

            count++;
        }

        curr.next = (curr1 != null) ? curr1 : curr2;
    }
}
