/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        flattentail(head);
        return head;
    }

    private Node flattentail(Node head) {
    	if (head == null) return head; // CASE 1
    	if (head.child == null) {
    		if (head.next == null) return head; // CASE 2
    		return flattentail(head.next); // CASE 3
    	} else {
    		Node child = head.child;  
    		head.child = null;
    		Node next = head.next;
    		Node childtail = flattentail(child);
    		head.next = child;
    		child.prev = head;  
			if (next != null) { // CASE 5
				childtail.next = next;
				next.prev = childtail;
				return flattentail(next);
			}
            return childtail; // CASE 4
    	}	 
}
