/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int val) {
                //create a cycle with single node if given list is empty 
        if (head == null) {
            Node res = new Node();
            res.val = val;
            res.next = res;
            return res;
        }
        //find the max node
        Node max = head;
        while (max.val <= max.next.val && max.next != head) max = max.next;
        //get the min node and point cur node to min node 
        Node min = max.next, cur = min;
        //if given val is < min or > max, then insert the new node after max.next 
        if (val <= min.val || val >= max.val) max.next = new Node(val, min);
        //otherwise find the correct position to insert
        else {
            while (cur.next != null && cur.next.val < val) cur = cur.next;
            cur.next = new Node(val, cur.next);
        }
        return head;
    }
}
