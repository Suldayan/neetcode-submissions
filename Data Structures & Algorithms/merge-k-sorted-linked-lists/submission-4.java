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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (aList, bList) -> Integer.compare(aList.val, bList.val)
        );

        for (final ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            final ListNode minNode = minHeap.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
