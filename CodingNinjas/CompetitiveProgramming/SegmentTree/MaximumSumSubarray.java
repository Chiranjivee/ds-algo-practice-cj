import java.util.Scanner;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class MaximumSumSubarray {
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
      	TreeNode [] tree = new TreeNode[4 * n];
      	for(int i = 0; i < tree.length; i++) tree[i] = new TreeNode();
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        buildTree(arr, tree, 0, n - 1, 1);
        int q = sc.nextInt();
      	for (int i = 0; i < q; i++) {
          	int l = sc.nextInt();
          	int r = sc.nextInt();
          
            TreeNode res = query(tree, 0, n - 1, l - 1, r - 1, 1);
            System.out.println(res.maxSum);
        }
	}

  	public static void buildTree(int[] arr, TreeNode [] tree, int start, int end, int treeNodeIdx) {
        if (start == end) {
            tree[treeNodeIdx].sum = arr[start];
            tree[treeNodeIdx].maxSum = arr[start];
            tree[treeNodeIdx].bestPrefixSum = arr[start];
            tree[treeNodeIdx].bestSuffixSum = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, (2 * treeNodeIdx) + 1);

        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[(2 * treeNodeIdx) + 1];
        tree[treeNodeIdx].sum = left.sum + right.sum;
        tree[treeNodeIdx].bestPrefixSum = Math.max(left.bestPrefixSum, left.sum + right.bestPrefixSum);
        tree[treeNodeIdx].bestSuffixSum = Math.max(right.bestSuffixSum, right.sum + left.bestSuffixSum);
        tree[treeNodeIdx].maxSum = 
            Math.max(
                Math.max(left.maxSum, right.maxSum),
                Math.max(
                    left.bestSuffixSum + right.bestPrefixSum, 
                    Math.max(
                        left.sum + right.bestPrefixSum, 
                        right.sum + left.bestSuffixSum)));
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
        res.sum = option1.sum + option2.sum;
        res.bestPrefixSum = Math.max(option1.bestPrefixSum, option1.sum + option2.bestPrefixSum);
        res.bestSuffixSum = Math.max(option2.bestSuffixSum, option2.sum + option1.bestSuffixSum);
        res.maxSum = 
            Math.max(
                Math.max(option1.maxSum, option2.maxSum),
                Math.max(
                    option1.bestSuffixSum + option2.bestPrefixSum, 
                    Math.max(
                        option1.sum + option2.bestPrefixSum, 
                        option2.sum + option1.bestSuffixSum)));
        return res;
    }
}
class TreeNode {
    long sum = Integer.MIN_VALUE;
    long maxSum = Integer.MIN_VALUE;
    long bestPrefixSum = Integer.MIN_VALUE;
    long bestSuffixSum = Integer.MIN_VALUE;
}
