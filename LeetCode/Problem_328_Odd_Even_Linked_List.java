/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddList = null;
        ListNode evenList = null;
        
        ListNode oddListIter = oddList;
        ListNode evenListIter = evenList;
        
        
        ListNode headIter = head;
        int i = 0;
        while (headIter != null) {
            ++i;
            if (i % 2 != 0) {
                // remove and append to odd list;
                ListNode curr = headIter;
                headIter = headIter.next;
                curr.next = null;
                
                if (oddList == null) {
                    oddList = curr;
                    oddListIter = curr;
                } else {
                    oddListIter.next = curr;
                    oddListIter = oddListIter.next;
                }
            } else {
                ListNode curr = headIter;
                headIter = headIter.next;
                curr.next = null;
                
                if (evenList == null) {
                    evenList = curr;
                    evenListIter = curr;
                } else {
                    evenListIter.next = curr;
                    evenListIter = evenListIter.next;
                }
            }
        }
        
        oddListIter.next = evenList;
        return oddList;
    }
}
