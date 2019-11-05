import java.util.*;

public class HelpMePradyumana {
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie trie = new Trie();
        while (n-- > 0) {
            String str = sc.next();
            trie.insert(str);
        }
        
        int q = sc.nextInt();
        while (q-- > 0) {
            String str = sc.next();
            List<String> words = trie.query(str);
            if (words.size() == 0) {
                trie.insert(str); 
            } else {
                for (String word : words)
                    System.out.println(word);
            }
        }
        sc.close();
	}
}

class TrieNode {
    boolean isEndOfWord;
    char currChar;
    TrieNode [] children;
    
    public TrieNode(char c) {
        this.currChar = c;
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}
    
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode('*');
    }
    
    public void insert(String s) {
        insert(root, s);
    }
    
    public void insert(TrieNode root, String s) {
        if (s.equals("")) {
            root.isEndOfWord = true;
            return;
        }
        
        char c = s.charAt(0);
        int cIdx = c - 'a';
        if (root.children[cIdx] == null) {
            root.children[cIdx] = new TrieNode(c);    
        }

        insert(root.children[cIdx], s.substring(1));
    }
    
    public List<String> query(String s) {
        List<String> words = new ArrayList<>();
        query(root, s, words, new StringBuilder());
        return words;
    }
    
    public void query(TrieNode root, String s, List<String> words, StringBuilder builder) {
        if (s.equals("")) {
            if (root.isEndOfWord) {
                words.add(builder.toString());
            }

            query(root.children[cIdx], s.substring(1), words, builder);
            return;
        }

        char c = s.charAt(0);
        int cIdx = c - 'a';
        
        if (root.children[cIdx] == null) {
            return;
        }

        builder.append(c);
        query(root.children[cIdx], s.substring(1), words, builder);
        return;
    }
}