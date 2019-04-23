import java.util.Scanner;

public class SearchEngine {
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Trie trie = new Trie();
        while (n-- > 0) {
            String str = sc.next();
            int weight = sc.nextInt();
            trie.insert(str, weight);
        }
        
        while (q-- > 0) {
            String str = sc.next();
            System.out.println(trie.query(str));
        }
	}
}

class TrieNode {
    int weight;
    char currChar;
    TrieNode [] children;
    
    public TrieNode(char c, int weight) {
        this.currChar = c;
        this.weight = weight;
        this.children = new TrieNode[26];
    }
}
    
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode('*', -1);
    }
    
    public void insert(String s, int weight) {
        insert(root, s, weight);
    }
    
    public void insert(TrieNode root, String s, int weight) {
        if (s.equals("")) {
            return;
        }
        
        char c = s.charAt(0);
        int cIdx = c - 'a';
        if (root.children[cIdx] == null) {
            root.children[cIdx] = new TrieNode(c, weight);    
        } else {
            // update weight if weight is greater
            if (weight > root.children[cIdx].weight)
                root.children[cIdx].weight = weight;
        }

        insert(root.children[cIdx], s.substring(1), weight);
    }
    
    public int query(String s) {
        return query(root, s);
    }
    
    public int query(TrieNode root, String s) {
        if (s.equals("")) {
            return root.weight;
        }

        char c = s.charAt(0);
        int cIdx = c - 'a';
        if (root.children[cIdx] == null) {
            return -1;
        }
        
        return query(root.children[cIdx], s.substring(1));
    }
}
