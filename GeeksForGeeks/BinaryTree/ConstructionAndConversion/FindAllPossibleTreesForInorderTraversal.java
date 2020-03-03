class Solution {
    public List<Node> findAll(int [] inorder, int start, int end) {
        List<Node> result= new ArrayList<>();
        for (int i = start; i <= end; i++)  {
            
            List<Node> leftSubTrees = findAll(inorder, start, i - 1);
            List<Node> rightSubTrees = findAll(inorder, i + 1, end);

            for (Node left : leftSubTrees) {
                for (Node right : rightSubTrees) {
                    Node node = new Node(inorder[i]);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

        return result;
    }
}
