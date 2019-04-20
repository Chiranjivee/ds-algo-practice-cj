/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while (curr != null) {
            if (next != null) {
                curr.next = next.next;
                next.next = curr;
                prev.next = next;
            }

            prev = prev.next.next;
            curr = curr.next;
            if (curr != null) next = curr.next;
        }
        return newHead.next;
    }
}
