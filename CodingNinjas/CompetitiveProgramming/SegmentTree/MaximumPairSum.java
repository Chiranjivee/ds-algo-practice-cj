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
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
	
	public static void main(String[] args) throws IOException {
		FastReader sc = new FastReader();
      	int n = sc.nextInt();
      	
      	int [] arr = new int [n];
      	TreeNode [] tree = new TreeNode[3 * n];
      	for(int i = 0; i < tree.length; i++) tree[i] = new TreeNode();
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        buildTree(arr, tree, 0, n - 1, 1);
        int q = sc.nextInt();
      	for (int i = 0; i < q; i++) {
          	char qu = sc.next().charAt(0);
          	int l = sc.nextInt();
          	int r = sc.nextInt();
          
          	if ('Q' == qu) {
              	TreeNode res = query(tree, 0, n - 1, l - 1, r - 1, 1);
              	System.out.println(res.max + res.secondMax);
            } else if ('U' == qu) {
              	updateTree(arr, tree, r, l - 1, 0, n - 1, 1);
            }
        }
	}

  	public static void buildTree(int[] arr, TreeNode [] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx].max = arr[start];
            tree[treeNodeIdx].secondMax = Integer.MIN_VALUE;
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, (2 * treeNodeIdx) + 1);

        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[(2 * treeNodeIdx) + 1];
        tree[treeNodeIdx].max = Math.max(left.max, right.max);
        tree[treeNodeIdx].secondMax = Math.min(
            Math.max(left.max, right.secondMax),
            Math.max(right.max, left.secondMax)
        );
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
        TreeNode option2 = query(tree, mid + 1, end, left, right, (2 * treeNodeIdx) + 1);

        TreeNode res = new TreeNode();
        res.max = Math.max(option1.max, option2.max);
        res.secondMax = Math.min(
            Math.max(option1.max, option2.secondMax),
            Math.max(option2.max, option1.secondMax)
        );
        return res;
    }

    public static void updateTree(int [] arr, TreeNode [] tree, int element, int index, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx].max = element;
            tree[treeNodeIdx].secondMax = Integer.MIN_VALUE;
            return;
        }

        int mid = (start + end) / 2;
        if (index > mid) {
            updateTree(arr, tree, element, index, mid + 1, end, (2 * treeNodeIdx) + 1);
        } else {
            updateTree(arr, tree, element, index, start, mid, 2 * treeNodeIdx);
        }

        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[(2 * treeNodeIdx) + 1];
        tree[treeNodeIdx].max = Math.max(left.max, right.max);
        tree[treeNodeIdx].secondMax = Math.min(
            Math.max(left.max, right.secondMax),
            Math.max(right.max, left.secondMax)
        );
    }

}
class TreeNode {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
}
