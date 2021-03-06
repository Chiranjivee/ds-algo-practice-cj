import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Trie {
    TrieNode root;

    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word : list) {
            root.insertWord(word);
        }
    }

    public Trie(String [] words) {
        root = new TrieNode();
        for (String word : words) {
            root.insertWord(word);
        }
    }

    public void remove(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        removeUtil(word, root);
    }

    public boolean removeUtil(String word, TrieNode current) {
        if (word.length() == 0) {
            current.isWordEnding = current.children.size() == 0;
            return current.isWordEnding;
        }

        char c = word.charAt(0);
        if (current.children.get(c) != null && removeUtil(word.substring(1), current.children.get(c))) {
            current.children.remove(current.children.get(c).character);
            return current.children.size() == 0 && !current.isWordEnding;
        }

        return false;
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !exact || lastNode.isWordEnding;
    }

    public boolean contains(String prefix) {
        return this.contains(prefix, false);
    }

    public static void main(String[] args) {
        String [] input = {"This", "is", "some", "random", "shit"};
        Trie trie = new Trie(input);

        System.out.println("Contains 'This' :" + trie.contains("This", true));
        System.out.println("Contains 'is' :" + trie.contains("is"));
        System.out.println("Contains 'some' :" + trie.contains("some"));
        System.out.println("Contains 'random' :" + trie.contains("random"));
        System.out.println("Contains 'somerandomshit' :" + trie.contains("somerandomshit"));

        System.out.println("Remove 'random':"); trie.remove("random");
        System.out.println("Contains 'random' :" + trie.contains("random"));

    }
}

class TrieNode {
    boolean isWordEnding;
    char character;
    Map<Character, TrieNode> children;

    public TrieNode(char c) {
        this();
        this.character = c;
    }

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public void insertWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        char firstChar = word.charAt(0);
        TrieNode child = getChild(firstChar);

        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if (word.length() > 1) {
            child.insertWord(word.substring(1));
        } else {
            child.isWordEnding = true;
        }
    }

    public TrieNode getChild(char c) {
        return this.children.get(c);
    }
}
