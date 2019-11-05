/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) return head;
        ListNode from = null;
        ListNode curr = head;
        int dummyM = m;
        if (m == 1) {
            return reverse(head, n - dummyM + 1);
        }

        while (--m > 1) {
            curr=curr.next;
        }
        
        from = curr;        
        from.next = reverse(from.next, n - dummyM + 1);
        return head;
    }
    
    public ListNode reverse(ListNode head, int n) {
        ListNode current = head;
        ListNode prev = null;
        
        if (current.next == null) {
            return head;
        } else {
            prev = current;
            current = current.next;
        }
        
        while (current != null && --n != 0) {
            ListNode currNext = current.next;
            prev.next = currNext;
            current.next = head;
            head = current;
            current = currNext;
        }
        
        return head;
    }
}
