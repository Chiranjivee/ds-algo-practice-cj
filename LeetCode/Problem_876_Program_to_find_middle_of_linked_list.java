/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return head;
        }
        
        if (head.next.next == null) {
            return head.next;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        return slowPtr.next;
    }
}