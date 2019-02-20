import java.util.Scanner;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class MaximumPairSum {
    static class Reader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readWord() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == ' ') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
	
	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
      	int n = sc.nextInt();
      	
      	int [] arr = new int [n];
      	TreeNode [] tree = new TreeNode[4 * n];
      	for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        buildTree(arr, tree, 0, n - 1, 1);
        int q = sc.nextInt();
      	for (int i = 0; i < q; i++) {
          	char qu = sc.readWord().charAt(0);
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
            TreeNode node = new TreeNode();
            node.max = arr[start];
            node.secondMax = Integer.MIN_VALUE;
            tree[treeNodeIdx] = node;
            return;
        }

        int mid = (start + end) / 2;

        buildTree(arr, tree, start, mid, 2 * treeNodeIdx);
        buildTree(arr, tree, mid + 1, end, 2 * treeNodeIdx + 1);

        TreeNode res = new TreeNode();
        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[2 * treeNodeIdx + 1];
        res.max = Math.max(left.max, right.max);
        res.secondMax = Math.min(
            Math.max(left.max, right.secondMax),
            Math.max(left.secondMax, right.max)
        );

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
        res.max = Math.max(option1.max, option2.max);
        res.secondMax = Math.min(
            Math.max(option1.max, option2.secondMax),
            Math.max(option1.secondMax, option2.max)
        );
        return res;
    }

    public static void updateTree(int [] arr, TreeNode [] tree, int element, int index, int start, int end, int treeNodeIdx) {
        if (start == end) {
            arr[index] = element;
            TreeNode node = new TreeNode();
            node.max = element;
            node.secondMax = Integer.MIN_VALUE;
            tree[treeNodeIdx] = node;
            return;
        }

        int mid = (start + end) / 2;
        if (index > mid) {
            updateTree(arr, tree, element, index, mid + 1, end, 2 * treeNodeIdx + 1);
        } else {
            updateTree(arr, tree, element, index, start, mid, 2 * treeNodeIdx);
        }

        TreeNode res = new TreeNode();
        TreeNode left = tree[2 * treeNodeIdx];
        TreeNode right = tree[2 * treeNodeIdx + 1];
        res.max = Math.max(left.max, right.max);
        res.secondMax = Math.min(
            Math.max(left.max, right.secondMax),
            Math.max(left.secondMax, right.max)
        );

        tree[treeNodeIdx] = res;
    }

}
class TreeNode {
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
}