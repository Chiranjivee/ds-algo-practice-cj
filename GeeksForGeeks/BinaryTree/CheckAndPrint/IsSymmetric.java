class SymmetricTree  {
    public boolean isSymmetric(Node root) {
        /* This allows adding null elements to the queue */
        Queue<Node> q = new LinkedList<Node> ();
    
        /* Initially, add left and right nodes of root */
        q.add(root.left);
        q.add(root.right);
    
        while (!q.isEmpty()) {
            /* remove the front 2 nodes to 
              check for equality */
            Node tempLeft = q.remove();
            Node tempRight = q.remove();
    
            /* if both are null, continue and chcek 
               for further elements */
            if (tempLeft == null && tempRight == null)
                continue;
    
            /* if only one is null---inequality, retun false */
            if ((tempLeft == null && tempRight != null) ||
                (tempLeft != null && tempRight == null))
                return false;
    
            /* if both left and right nodes exist, but 
               have different values-- inequality, 
               return false*/
            if (tempLeft.val != tempRight.val)
                return 0;
    
            /* Note the order of insertion of elements 
               to the queue : 
               1) left child of left subtree 
               2) right child of right subtree 
               3) right child of left subtree 
               4) left child of right subtree */
            q.add(tempLeft.left);
            q.add(tempRight.right);
            q.add(tempLeft.right);
            q.add(tempRight.left);
        }
    
        /* if the flow reaches here, return true*/
        return true;
    }    
}
