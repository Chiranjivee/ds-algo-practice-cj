/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode res = new ListNode(0);
        ListNode curr3 = res;
        
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int digit1 = curr1 != null ? curr1.val : 0;
            int digit2 = curr2 != null ? curr2.val : 0;
            
            int sum = digit1 + digit2 + carry;
            ListNode tempResult = new ListNode(sum % 10);
            curr3.next = tempResult;
            curr3 = curr3.next;
            
            carry = sum / 10;
            
            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
        }
        
        if (carry > 0) curr3.next = new ListNode(carry);
        return res.next;
    }
}
