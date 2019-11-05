class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode(c);
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];    
            }
        }
        return curr.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];    
            }
        }
        return true;
    }
}


class TrieNode {
    char currChar;
    boolean isEndOfWord;
    TrieNode [] children;
    
    public TrieNode(char c) {
        this.currChar = c;
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
