import java.util.Scanner;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        // Write your code here
        int t = in.nextInt();
        int r = 0;
        while (r++ < t) {
            System.out.println("Case " + r + ":");
            int n = in.nextInt();
            int q = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            TreeNode[] tree = new TreeNode[4 * n];
            buildTree(arr, tree, 0, n - 1, 1);
            LazyTreeNode[] lazy = new LazyTreeNode[4 * n];

            while (q-- > 0) {

                int type = in.nextInt();
                if (type == 0) {
                    int st = in.nextInt();
                    int end = in.nextInt();
                    int x = in.nextInt();
                    update(tree, lazy, 0, n - 1, st - 1, end - 1, x, 1, 0);
                } else if (type == 1) {
                    int st = in.nextInt();
                    int end = in.nextInt();
                    int x = in.nextInt();
                    update(tree, lazy, 0, n - 1, st - 1, end - 1, x, 1, 1);
                } else if (type == 2) {
                    int st = in.nextInt();
                    int end = in.nextInt();
                    System.out.println(query(tree, lazy, 0, n - 1, st - 1, end - 1, 1).sqSum);
                }
            }
        }
    }

    public static void buildTree(int[] arr, TreeNode[] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx] = new TreeNode();
            tree[treeNodeIdx].sum = arr[start];
            tree[treeNodeIdx].sqSum = arr[start] * arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, (2 * treeNodeIdx) + 1);

        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[(2 * treeNodeIdx) + 1];
        tree[treeNodeIdx] = new TreeNode();
        tree[treeNodeIdx].sum = left.sum + right.sum;
        tree[treeNodeIdx].sqSum = left.sqSum + right.sqSum;
    }

    public static void update(TreeNode[] tree, LazyTreeNode[] lazy, int low, int high, int startR, int endR,
            long element, int currentPosition, int type) {

        if (low > high) {
            return;
        }

        if (lazy[currentPosition] != null && lazy[currentPosition].type != -1) {
            if (lazy[currentPosition].type == 1) {
                tree[currentPosition].sqSum += lazy[currentPosition].value * lazy[currentPosition].value
                        * (high - low + 1);
                tree[currentPosition].sqSum += 2 * lazy[currentPosition].value * tree[currentPosition].sum;
                tree[currentPosition].sum += lazy[currentPosition].value * (high - low + 1);
            } else if (lazy[currentPosition].type == 0) {
                tree[currentPosition].sqSum = lazy[currentPosition].value * lazy[currentPosition].value
                        * (high - low + 1);
                tree[currentPosition].sum = lazy[currentPosition].value * (high - low + 1);
            }

            if (low != high) {
                lazy[currentPosition * 2] = new LazyTreeNode();
                lazy[currentPosition * 2].type = lazy[currentPosition].type;
                lazy[currentPosition * 2].value = lazy[currentPosition].value;

                lazy[(2 * currentPosition) + 1] = new LazyTreeNode();
                lazy[currentPosition * 2 + 1].type = lazy[currentPosition].type;
                lazy[currentPosition * 2 + 1].value = lazy[currentPosition].value;
            }

            lazy[currentPosition] = null;
        }

        // No overlap
        if (startR > high || endR < low) {
            return;
        }

        // complete overlap
        if (startR <= low && high <= endR) {
            // Update by increment.
            if (type == 1) {
                tree[currentPosition].sqSum += (element * element) * (high - low + 1);
                tree[currentPosition].sqSum += (2 * tree[currentPosition].sum * element);
                tree[currentPosition].sum += (element * (high - low + 1));

                if (low != high) {
                    lazy[currentPosition * 2] = new LazyTreeNode();
                    lazy[currentPosition * 2].type = 1;
                    lazy[currentPosition * 2].value = element;

                    lazy[(2 * currentPosition) + 1] = new LazyTreeNode();
                    lazy[currentPosition * 2 + 1].type = 1;
                    lazy[currentPosition * 2 + 1].value = element;
                }
            }
            // Update by value.
            else if (type == 0) {
                tree[currentPosition] = new TreeNode();
                tree[currentPosition].sqSum += (element * element * (high - low + 1));
                tree[currentPosition].sum += (element * (high - low + 1));

                if (low != high) {
                    lazy[currentPosition * 2] = new LazyTreeNode();
                    lazy[currentPosition * 2].type = 0;
                    lazy[currentPosition * 2].value = element;

                    lazy[(2 * currentPosition) + 1] = new LazyTreeNode();
                    lazy[currentPosition * 2 + 1].type = 0;
                    lazy[currentPosition * 2 + 1].value = element;
                }
            }
            return;
        }

        int mid = (low + high) / 2;
        update(tree, lazy, low, mid, startR, endR, element, currentPosition * 2, type);
        update(tree, lazy, mid + 1, high, startR, endR, element, (currentPosition * 2) + 1, type);

        tree[currentPosition].sum = tree[2 * currentPosition].sum + tree[2 * currentPosition + 1].sum;
        tree[currentPosition].sqSum = tree[2 * currentPosition].sqSum + tree[2 * currentPosition + 1].sqSum;
    }

    public static TreeNode query(TreeNode[] tree, LazyTreeNode[] lazy, int low, int high, int startR, int endR,
            int currentPosition) {
        if (lazy[currentPosition] != null && lazy[currentPosition].type != -1) {
            if (lazy[currentPosition].type == 1) {
                // Update by incriment
                tree[currentPosition].sqSum += ((lazy[currentPosition].value * lazy[currentPosition].value)
                        * (high - low + 1) + (2 * lazy[currentPosition].value * tree[currentPosition].sum));

                tree[currentPosition].sum += (lazy[currentPosition].value * (high - low + 1));
            } else if (lazy[currentPosition].type == 0) {
                // Update by value.
                tree[currentPosition].sqSum = (lazy[currentPosition].value * lazy[currentPosition].value
                        * (high - low + 1));
                tree[currentPosition].sum = (lazy[currentPosition].value * (high - low + 1));
            }

            if (high != low) {
                lazy[2 * currentPosition] = new LazyTreeNode();
                lazy[2 * currentPosition].type = lazy[currentPosition].type;
                lazy[2 * currentPosition].value = lazy[currentPosition].value;

                lazy[(2 * currentPosition) + 1] = new LazyTreeNode();
                lazy[(2 * currentPosition) + 1].type = lazy[currentPosition].type;
                lazy[(2 * currentPosition) + 1].value = lazy[currentPosition].value;
            }
            lazy[currentPosition] = null;
        }
        // Fully outside
        if (startR > high || endR < low)
            return new TreeNode();
        // Fully overlap
        if (startR <= low && high <= endR)
            return tree[currentPosition];

        // Partially overlap
        int mid = (low + high) / 2;
        TreeNode left = query(tree, lazy, low, mid, startR, endR, currentPosition * 2);
        TreeNode right = query(tree, lazy, mid + 1, high, startR, endR, currentPosition * 2 + 1);
        TreeNode ans = new TreeNode();
        ans.sqSum = left.sqSum + right.sqSum;
        ans.sum = left.sum + right.sum;
        return ans;
    }
}

class TreeNode {
    long sum = 0;
    long sqSum = 0;

    @Override
    public String toString() {
        return this.sum + " " + this.sqSum;
    }
}

class LazyTreeNode {
    int type = -1;
    long value;
}
