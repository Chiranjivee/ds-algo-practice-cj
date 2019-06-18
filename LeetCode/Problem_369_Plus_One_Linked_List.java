/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = plusOneUtil(head);
        if (carry == 0) {
            return head;
        } else {
            ListNode node = new ListNode(carry);
            node.next = head;
            return node;
        }
    }
    
    public int plusOneUtil(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        if (head.next == null) {
            head.val += 1;
            int carry = head.val / 10;
            head.val %= 10;
            return carry;
        }
        
        int carry = plusOneUtil(head.next);
        if (carry == 0) return 0;
        
        head.val += 1;
        carry = head.val / 10;
        head.val %= 10;
        return carry;
    }
}
