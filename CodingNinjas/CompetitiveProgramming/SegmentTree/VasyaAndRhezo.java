import java.util.Scanner;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
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
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        TreeNode[] tree = new TreeNode[4 * n];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new TreeNode();
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = sc.nextInt();
        buildTree(A, B, tree, 0, n - 1, 1);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            TreeNode res = query(tree, 0, n - 1, l - 1, r - 1, 1);
            System.out.println(res.index + 1);
        }
    }

    public static void buildTree(int[] A, int[] B, TreeNode[] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx].max = A[start];
            tree[treeNodeIdx].min = B[start];
            tree[treeNodeIdx].index = start;
            return;
        }

        int mid = (start + end) / 2;

        buildTree(A, B, tree, start, mid, 2 * treeNodeIdx);
        buildTree(A, B, tree, mid + 1, end, (2 * treeNodeIdx) + 1);

        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[(2 * treeNodeIdx) + 1];

        if (left.max == right.max) {
            if (left.min == right.min) {
                if (left.index < right.index) {
                    tree[treeNodeIdx].max = left.max;
                    tree[treeNodeIdx].min = left.min;
                    tree[treeNodeIdx].index = left.index;
                } else {
                    tree[treeNodeIdx].max = right.max;
                    tree[treeNodeIdx].min = right.min;
                    tree[treeNodeIdx].index = right.index;
                }
            } else if (left.min < right.min) {
                tree[treeNodeIdx].max = left.max;
                tree[treeNodeIdx].min = left.min;
                tree[treeNodeIdx].index = left.index;
            } else {
                tree[treeNodeIdx].max = right.max;
                tree[treeNodeIdx].min = right.min;
                tree[treeNodeIdx].index = right.index;
            }
        } else if (left.max > right.max) {
            tree[treeNodeIdx].max = left.max;
            tree[treeNodeIdx].min = left.min;
            tree[treeNodeIdx].index = left.index;
        } else {
            tree[treeNodeIdx].max = right.max;
            tree[treeNodeIdx].min = right.min;
            tree[treeNodeIdx].index = right.index;
        }
    }

    public static TreeNode query(TreeNode[] tree, int start, int end, int left, int right, int treeNodeIdx) {
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
        TreeNode option2 = query(tree, mid + 1, end, left, right, (2 * treeNodeIdx) + 1);

        TreeNode res = new TreeNode();
        if (option1.max == option2.max) {
            if (option1.min == option2.min) {
                if (option1.index < option2.index) {
                    res.max = option1.max;
                    res.min = option1.min;
                    res.index = option1.index;
                } else {
                    res.max = option2.max;
                    res.min = option2.min;
                    res.index = option2.index;
                }
            } else if (option1.min < option2.min) {
                res.max = option1.max;
                res.min = option1.min;
                res.index = option1.index;
            } else {
                res.max = option2.max;
                res.min = option2.min;
                res.index = option2.index;
            }
        } else if (option1.max > option2.max) {
            res.max = option1.max;
            res.min = option1.min;
            res.index = option1.index;
        } else {
            res.max = option2.max;
            res.min = option2.min;
            res.index = option2.index;
        }
        return res;
    }
}

class TreeNode {
    long max = Integer.MIN_VALUE;
    long min = Integer.MAX_VALUE;
    int index = Integer.MAX_VALUE;

    @Override
    public String toString() {
        return this.max + " " + this.min + " " + this.index;
    }
}
