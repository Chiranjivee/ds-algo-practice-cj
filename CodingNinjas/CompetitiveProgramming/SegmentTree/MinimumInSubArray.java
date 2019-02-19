import java.util.Scanner;
import java.util.Arrays;
public class MinimumInSubArray {
	
  	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
      	int n = sc.nextInt();
      	int q = sc.nextInt();
      	int [] arr = new int [n];
      	int [] tree = new int[4 * n];
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      	buildTree(arr, tree, 0, n - 1, 1);
      	for (int i = 0; i < q; i++) {
          	String qu = sc.next();
          	int l = sc.nextInt();
          	int r = sc.nextInt();
          
          	if ("q".equals(qu)) {
              	int res = query(tree, 0, n - 1, l - 1, r - 1, 1);
              	System.out.println(res);
            } else if ("u".equals(qu)) {
              	updateTree(arr, tree, r, l - 1, 0, n - 1, 1);
            }
        }
	}

  	public static void buildTree(int[] arr, int [] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, 2 * treeNodeIdx + 1);

        tree[treeNodeIdx] = Math.min(tree[2 * treeNodeIdx], tree[2 * treeNodeIdx + 1]);
    }

    public static int query(int [] tree, int start, int end, int left, int right, int treeNodeIdx) {
        // Completely outside the given range.
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }

        // Completely inside the given range.
        if (start >= left && end <= right) {
            return tree[treeNodeIdx];
        }

        // Partially inside and partially outside.
        int mid = (start + end) / 2;
        int option1 = query(tree, start, mid, left, right, 2 * treeNodeIdx);
        int option2 = query(tree, mid + 1, end, left, right, 2 * treeNodeIdx + 1);

        return Math.min(option1, option2);
    }

    public static void updateTree(int [] arr, int [] tree, int element, int index, int start, int end, int treeNodeIdx) {
        if (start == end) {
            arr[index] = element;
            tree[treeNodeIdx] = element;
            return;
        }

        int mid = (start + end) / 2;
        if (index > mid) {
            updateTree(arr, tree, element, index, mid + 1, end, 2 * treeNodeIdx + 1);
        } else {
            updateTree(arr, tree, element, index, start, mid, 2 * treeNodeIdx);
        }
        tree[treeNodeIdx] = Math.min(tree[2 * treeNodeIdx], tree[2 * treeNodeIdx + 1]);
    }
}