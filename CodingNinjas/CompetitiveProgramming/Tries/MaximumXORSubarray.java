import java.util.Scanner;

public class Main {
    public static class TrieNode {
        TrieNode left, right;
        int value = 0;
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        void insert(int val) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new TrieNode();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new TrieNode();
                    }

                    curr = curr.right;
                }
            }
            curr.value = val;
        }

        int query(int xor) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (xor >> i) & 1;
                if (bit == 0) {
                    if (curr.right != null) {
                        curr = curr.right;
                    } else if (curr.left != null) {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null) {
                        curr = curr.left;

                    } else if (curr.right != null) {
                        curr = curr.right;
                    }
                }
            }

            return xor ^ curr.value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int maxXor = Integer.MIN_VALUE;

        Trie trie = new Trie();
        int xor = 0;
        trie.insert(xor);

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            TrieNode curr = trie.root;
            xor = xor ^ arr[i];
            trie.insert(xor);
            maxXor = Math.max(maxXor, trie.query(xor));
        }

        System.out.println(maxXor);
    }
}
