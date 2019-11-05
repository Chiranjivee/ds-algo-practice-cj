/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(11, (a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                System.out.println(node.val);
                pq.add(node);
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            
            if (tail.next != null) pq.add(tail.next);
        }
        
        return head.next;
    }
}
