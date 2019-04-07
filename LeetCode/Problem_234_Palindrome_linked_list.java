/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode current = head;
        
        while (current != null) {
            st.push(current.val);
            current = current.next;
        }
        
        current = head;
        while (current != null) {
            if (current.val != st.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }
}
