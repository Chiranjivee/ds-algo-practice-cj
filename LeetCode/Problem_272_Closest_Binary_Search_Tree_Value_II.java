/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root == null) return null;
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((t1,t2) -> Double.compare(Math.abs(t2.val - target), Math.abs(t1.val - target)));
        
        dfs(root, pq, k);
        List<Integer> res =  new ArrayList<Integer>();
        while(!pq.isEmpty()){
            res.add(pq.poll().val);
        }
        return res;
    }
    
    void dfs(TreeNode root, PriorityQueue<TreeNode> pq, int k){
        if(root == null) return;
        
        pq.add(root);
        if(pq.size() > k){
            pq.poll();
        }
        
        dfs(root.left, pq, k);
        dfs(root.right, pq, k);
        
    }
}
