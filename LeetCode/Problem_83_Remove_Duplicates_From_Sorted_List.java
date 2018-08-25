/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            if (curr.val == next.val) {
                curr.next = next.next;
                next = next.next;
            } else {
                curr = curr.next;
                next = curr.next;
            }
            
        }
        
        return head;
    }
}
