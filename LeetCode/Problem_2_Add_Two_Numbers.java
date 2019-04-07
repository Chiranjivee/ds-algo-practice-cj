class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        int x = 0;
        int y = 0;
        int c = 0;
        
        ListNode res = new ListNode(0);
        ListNode curr = res;

        StringBuilder builder = new StringBuilder();
        while (l1 != null || l2 != null) {
            x = (l1 == null) ? 0 : l1.val;
            y = (l2 == null) ? 0 : l2.val;
            
            builder.append((x + y + c) % 10);
            curr.next = new ListNode((x + y + c) % 10);
            c = (x + y + c) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }
        
        if (c != 0) curr.next = new ListNode(c);
        return res.next;
    }
}