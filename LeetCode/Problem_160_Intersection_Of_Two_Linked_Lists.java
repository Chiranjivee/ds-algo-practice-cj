/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        Stack<ListNode> st = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        
        int len1 = 0;
        while (curr1 != null) {
            curr1 = curr1.next;
            len1++;
        }
        
        int len2 = 0;
        while (curr2 != null) {
            curr2 = curr2.next;
            len2++;
        }
        
        curr1 = headA;
        curr2 = headB;
        int diff = Math.abs(len1 - len2);
        if (len1 > len2) {
            while (diff > 0) {
                curr1 = curr1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                curr2 = curr2.next;
                diff--;
            }
        }
        
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }
}
