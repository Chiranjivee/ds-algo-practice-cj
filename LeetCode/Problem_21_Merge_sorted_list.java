/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode result = res;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                result.next = head2;
                return res.next;
            }
            
            if (head2 == null) {
                result.next = head1;
                return res.next;
            } 
            
            if (head1.val < head2.val) {
                result.next = head1;
                head1 = head1.next;
            } else {
                result.next = head2;
                head2 = head2.next;
            }
            
            result = result.next;
        }
        
        return res.next;
    }
}
