class Solution {
    private static void printMiddleLevelUtil(Node a, Node b) {

	if (a == null || b == null) return;

	if ((b.left == null) && (b.right == null)) {
		System.out.print(a.key + " ");
		return;
	}

	printMiddleLevelUtil(a.left, b.left.left);
	printMiddleLevelUtil(a.right, b.left.left);
}
}