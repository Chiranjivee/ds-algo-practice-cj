class XORMaximumPair {
    public static void main(String[] args) {
        int [] arr = new int[] {8, 1, 2, 15, 10, 5};

        Trie trie = new Trie();
        for (Integer e : arr) {
            trie.insert(e);
        }
        
        
        int ans = findMaxXorPair(trie, arr);
        System.out.println(ans);
    }

    public static int findMaxXorPair(Trie trie, int[] arr) {
        int maxXor = Integer.MIN_VALUE;
        

        for (int i = 0; i < arr.length; i++) {
            TrieNode curr = trie.root;
            int val = arr[i];
            int currXor = 0;
            for (int j = 31; j >= 0; j--) {
                int b = (val >> j) & 1;
                if (b == 0) {
                    if (curr.right != null) {
                        currXor += (1 << j);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null) {
                        currXor += (1 << j);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                }
            }

            maxXor = Math.max(currXor, maxXor);
        }

        return maxXor;
    }
}

class TrieNode { 
    TrieNode left;
    TrieNode right;
}

class Trie {
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
                    curr.right= new TrieNode();
                }

                curr = curr.right;                
            }
        }
    }
}