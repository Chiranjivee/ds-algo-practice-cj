/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode curr = head;
        ListNode tail = null;
        // find length and tail
        while (curr != null) {
            if (curr.next == null) {
                tail = curr;
            }
            curr = curr.next;
            len++;
        }

        k %= len;
        k = len - k;
        while (k-- > 0) {
            // remove the head
            ListNode curre = head;
            head = head.next;
            curre.next = null;

            tail.next = curre; // add to tail
            tail = curre; // update tail

        }

        return head;
    }
}
