/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int [] res = new int[getLength(head)];
        
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            res[i] = curr.val;
            curr = curr.next;
            i += 1;
        }
        
        Stack<Integer> st = new Stack<>();
        i = 0;
        while (i < res.length) {
            if (st.isEmpty()) {
                st.push(i++);
                continue;
            }
            
            if (res[i] < res[st.peek()]) {
                st.push(i++);
            } else {
                while (!st.isEmpty() && res[st.peek()] < res[i]) {
                    System.out.println("Peek:" + st.peek() + ", res[i]:" + res[i]);
                    res[st.pop()] = res[i];
                }
                st.push(i++);
            }
        }
        
        while (!st.isEmpty()) {
            res[st.pop()] = 0;
        }
        return res;
        
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
