/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode l1 = node1;
        ListNode l2 = node2;
        
        while (head != null) {
            if (head.val < x) {
                l1 = l1.next = head;
            } else {
                l2 = l2.next = head;
            }
            head = head.next;
        }
        
        l2.next = null;
        l1.next = node2.next;
        return node1.next;
    }
}
