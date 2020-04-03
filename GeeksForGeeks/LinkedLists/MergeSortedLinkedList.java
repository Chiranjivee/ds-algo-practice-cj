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
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        ListNode result = new ListNode(0);
        ListNode curr3 = result;
        while (curr1 != null || curr2 != null) {
            int optionOne = curr1 != null ? curr1.val : Integer.MAX_VALUE;
            int optionTwo = curr2 != null ? curr2.val : Integer.MAX_VALUE;
            
            int r = Math.min(optionOne, optionTwo);
            if (r == optionOne) {
                curr1 = curr1 != null ? curr1.next : null;
            } else {
                curr2 = curr2 != null ? curr2.next : null;
            }
            
            ListNode res = new ListNode(r);
            curr3.next = res;
            curr3 = curr3.next;
        }
        
        return result.next;
    }
}
