import java.util.Arrays;

class MinWithLazyPropagation {

    public static void main(String[] args) {
        int [] arr = new int [] {1, 3, -2, 4};
        int [] tree = new int[12];
        buildTree(arr, tree, 0, 3, 1);
        int [] lazy = new int[12];
        update(tree, lazy, 0, 3, 0, 3, 3, 1);
        System.out.println("Segment tree: " + Arrays.toString(tree));
        System.out.println("Lazy tree: " + Arrays.toString(lazy));

        update(tree, lazy, 0, 3, 0, 1, 2, 1);

        System.out.println("Segment tree: " + Arrays.toString(tree));
        System.out.println("Lazy tree: " + Arrays.toString(lazy));

        System.out.println(query(tree, lazy, 0, 3, 1, 2, 1));
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

    public static void update(int [] tree, int [] lazy, int low, int high, int startR, int endR, int element, int currentPosition) {

        if (low > high) {
            return;
        }

        if (lazy[currentPosition] != 0) {
            tree[currentPosition] += lazy[currentPosition];

            if (low != high) {
                lazy[currentPosition * 2] += lazy[currentPosition];
                lazy[currentPosition * 2 + 1] += lazy[currentPosition];
            }

            lazy[currentPosition] = 0;
        }

        // No overlap
        if (startR > high || endR < low) {
            return;
        }

        // complete overlap
        if (startR <= low && high <= endR) {
            tree[currentPosition] += element;
            if (low != high) {
                lazy[2 * currentPosition] += element;
                lazy[2 * currentPosition + 1] += element;
            }
            return;
        }

        // Partial overlap
        System.out.println("Partial");
        int mid = (low + high) / 2;
        update(tree, lazy, low, mid, startR, endR, element, currentPosition * 2);
        update(tree, lazy, mid + 1, high, startR, endR, element, currentPosition * 2 + 1);

        tree[currentPosition] = Math.min(tree[2 * currentPosition], tree[2 * currentPosition + 1]);
    }

    public static int query(int [] tree, int [] lazy, int low, int high, int startR, int endR, int currentPosition) {
        if (lazy[currentPosition] != 0) {
            tree[currentPosition] += lazy[currentPosition];
            if (low != high) {
                lazy[currentPosition * 2] += lazy[currentPosition];
                lazy[currentPosition * 2 + 1] += lazy[currentPosition];
            }
            lazy[currentPosition] = 0;
        }

        // fully outside
        if (startR > high || endR < low) {
            return Integer.MAX_VALUE;
        }

        if (startR <= low && endR >= high) {
            return tree[currentPosition];
        }

        int mid = (low + high) / 2;
        int option1 = query(tree, lazy, low, mid, startR, endR, currentPosition * 2);
        int option2 = query(tree, lazy, mid + 1, high, startR, endR, currentPosition * 2 + 1);
        return Math.min(option1, option2);
    }
}
