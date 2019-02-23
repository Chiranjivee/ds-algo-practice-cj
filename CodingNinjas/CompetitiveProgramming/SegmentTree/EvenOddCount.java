import java.util.Scanner;
import java.util.Arrays;

public class EvenOddCount {
  	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int [] arr = new int [n];
      	TreeNode [] tree = new TreeNode[4 * n];
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      	buildTree(arr, tree, 0, n - 1, 1);
        int q = sc.nextInt();
      	for (int i = 0; i < q; i++) {
          	String qu = sc.next();
          	int l = sc.nextInt();
          	int r = sc.nextInt();
          	if ("0".equals(qu)) {
              	updateTree(arr, tree, r, l - 1, 0, n - 1, 1);
            } else if ("1".equals(qu)) {
              	System.out.println(query(tree, 0, n - 1, l - 1, r - 1, 1).evenCount);
            } else if ("2".equals(qu)) {
              	System.out.println(query(tree, 0, n - 1, l - 1, r - 1, 1).oddCount);
            }
        }
        sc.close();
	}

  	public static void buildTree(int[] arr, TreeNode [] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            TreeNode node = new TreeNode();
          	if (arr[start] % 2 == 0) {
              	node.evenCount++;
            } else {
              	node.oddCount++;
            }
            tree[treeNodeIdx] = node;
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, (2 * treeNodeIdx) + 1);
      
      	TreeNode left = tree[2 * treeNodeIdx];
      	TreeNode right = tree[2 * treeNodeIdx + 1];
      	TreeNode res = new TreeNode();
      	res.evenCount = left.evenCount + right.evenCount;
      	res.oddCount = left.oddCount + right.oddCount;
        tree[treeNodeIdx] = res;
    }

    public static TreeNode query(TreeNode [] tree, int start, int end, int left, int right, int treeNodeIdx) {
        // Completely outside the given range.
        if (start > right || end < left) {
            return new TreeNode();
        }

        // Completely inside the given range.
        if (start >= left && end <= right) {
            return tree[treeNodeIdx];
        }

        // Partially inside and partially outside.
        int mid = (start + end) / 2;
        TreeNode option1 = query(tree, start, mid, left, right, 2 * treeNodeIdx);
        TreeNode option2 = query(tree, mid + 1, end, left, right, 2 * treeNodeIdx + 1);
		TreeNode res = new TreeNode();
      	res.evenCount = option1.evenCount + option2.evenCount;
      	res.oddCount = option1.oddCount + option2.oddCount;
        return res;
    }

    public static void updateTree(int [] arr, TreeNode [] tree, int element, int index, int start, int end, int treeNodeIdx) {
        if (start == end) {
          	int prevElement = arr[index];
            arr[index] = element;
          	if (element % 2 == 0 && prevElement % 2 != 0) { 
            	tree[treeNodeIdx].evenCount++;
              	tree[treeNodeIdx].oddCount--;
            } else if (element % 2 != 0 && prevElement % 2 == 0) {
              	tree[treeNodeIdx].evenCount--;
              	tree[treeNodeIdx].oddCount++;
            }
            return;
        }

        int mid = (start + end) / 2;
        if (index > mid) {
            updateTree(arr, tree, element, index, mid + 1, end, 2 * treeNodeIdx + 1);
        } else {
            updateTree(arr, tree, element, index, start, mid, 2 * treeNodeIdx);
        }
      	TreeNode left = tree[2 * treeNodeIdx];
      	TreeNode right = tree[2 * treeNodeIdx + 1];
        tree[treeNodeIdx].evenCount = left.evenCount + right.evenCount;
       	tree[treeNodeIdx].oddCount = left.oddCount + right.oddCount;
    }
}

class TreeNode {
  	int evenCount;
  	int oddCount;
}
