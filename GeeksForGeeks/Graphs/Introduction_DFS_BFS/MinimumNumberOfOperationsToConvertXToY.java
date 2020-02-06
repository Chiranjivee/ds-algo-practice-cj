class Node {
	int val;
	int steps;

	public Node(int val, int steps) {
		this.val = val;
		this.steps = steps;
	}
}

public class ConvertXToY {
	private static int minOperations(int src,
		int target) {

		Set<Node> visited = new HashSet<>(1000);
		LinkedList<Node> queue = new LinkedList<Node> ();

		Node node = new Node(src, 0);

		queue.offer(node);
		visited.add(node);

		while (!queue.isEmpty()) {
			GFG temp = queue.poll();
			visited.add(temp);

			if (temp.val == target) {
				return temp.steps;
			}

			int mul = temp.val * 2;
			int sub = temp.val - 1;

			// given constraints 
			if (mul > 0 && mul<1000) {
				Node nodeMul = new GFG(mul, temp.steps + 1);
				queue.offer(nodeMul);
			}
			if (sub > 0 && sub<1000) {
				Node nodeSub = new GFG(sub, temp.steps + 1);
				queue.offer(nodeSub);
			}
		}
		return -1;
    }
}
