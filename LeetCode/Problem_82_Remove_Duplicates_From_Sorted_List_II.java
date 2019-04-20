/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode next = dummyNode.next;
        while (next != null) {
            boolean isDelete = false;
            while (next.next != null && next.val == next.next.val) {
                isDelete = true;
                next.next = next.next.next;
            }
            if (isDelete) {
                prev.next = next.next;
                next = next.next;
            } else {
                prev = prev.next;
                next = next.next;
            }
        }
        return dummyNode.next;
    }
}
