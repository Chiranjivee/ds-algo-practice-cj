/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return mergeLists(l1, l2);
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
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
