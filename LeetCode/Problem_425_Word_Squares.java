
class TrieNode {
    Map<Character, TrieNode> children;
    List<String> startWith;
    public TrieNode() {
        children = new HashMap<>();
        startWith = new ArrayList<>();
    }
}

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0)
            return res;
        TrieNode root = buildTrie(words);
        int len = words[0].length();
        List<String> sublist = new ArrayList<>();
        for(String word: words){
            sublist.add(word);
            dfs(len, root, sublist, res);
            sublist.remove(sublist.size() - 1);
        }
        return res;
    }
    
    private void dfs(int len, TrieNode root, List<String> sublist, List<List<String>> res) {
        if(sublist.size() == len) {
            res.add(new ArrayList<>(sublist));
            return;
        }
        
        int index = sublist.size();
        StringBuilder prefixSb = new StringBuilder();
        for(String s: sublist) {
            prefixSb.append(s.charAt(index));
        }
        List<String> prefixStr = findByPrefix(prefixSb.toString(), root);
        for(String s: prefixStr) {
            sublist.add(s);
            dfs(len, root, sublist, res);
            sublist.remove(sublist.size() - 1);
        }
    }
    
    private List<String> findByPrefix(String s, TrieNode root) {
        List<String> res = new ArrayList<>();
        TrieNode node = root;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!node.children.containsKey(c)) {
                return res;
            }
            node = node.children.get(c);
        }
        res.addAll(node.startWith);
        return res;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node.children.get(c).startWith.add(word);
                node = node.children.get(c);
            }
        }
        return root;
    }
}
