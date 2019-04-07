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
        int x = 0;
        int y = 0;
        int c = 0;
        
        ListNode res = new ListNode(0);
        ListNode curr = res;

        StringBuilder builder = new StringBuilder();
        
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        ListNode curr1 = l1;
        while(curr1 != null) {
            st1.push(curr1);
            curr1 = curr1.next;
        }
        
        ListNode curr2 = l2;
        while(curr2 != null) {
            st2.push(curr2);
            curr2 = curr2.next;
        }
        
        
        while (!st1.isEmpty() || !st2.isEmpty()) {
            x = (st1.isEmpty()) ? 0 : st1.pop().val;
            y = (st2.isEmpty()) ? 0 : st2.pop().val;
            
            builder.append((x + y + c) % 10);
            curr.next = new ListNode((x + y + c) % 10);
            c = (x + y + c) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }
        
        if (c != 0) curr.next = new ListNode(c);
        ListNode curr3 = res.next;
        
        return reverse(res.next);
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}