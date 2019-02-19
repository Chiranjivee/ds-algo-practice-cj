import java.util.Arrays;
class BuildSegmentTree {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 3, 4, 5};
        int tree[] = new int[10]; // double the array size.

        buildTree(arr, tree, 0, 4, 1);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Tree" + Arrays.toString(tree));

        updateTree(arr, tree, 10, 2, 0, 4, 1);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Tree" + Arrays.toString(tree));

        int ans = query(tree, 0, 4, 1, 2, 1);
    }

    public static void buildTree(int[] arr, int [] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, 2 * treeNodeIdx + 1);

        tree[treeNodeIdx] = tree[2 * treeNodeIdx] + tree[2 * treeNodeIdx + 1];
    }

    public static int query(int [] tree, int start, int end, int left, int right, int treeNodeIdx) {
        // Completely outside the given range.
        if (start > right || end < left) {
            return 0;
        }

        // Completely inside the given range.
        if (start >= left && end <= right) {
            return tree[treeNodeIdx];
        }

        // Partially inside and partially outside.
        int mid = (start + end) / 2;
        int option1 = query(tree, start, mid, left, right, 2 * treeNodeIdx);
        int option2 = query(tree, mid + 1, end, left, right, 2 * treeNodeIdx + 1);

        return option1 + option2;
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
        tree[treeNodeIdx] = tree[2 * treeNodeIdx] + tree[2 * treeNodeIdx + 1];
    }
}
