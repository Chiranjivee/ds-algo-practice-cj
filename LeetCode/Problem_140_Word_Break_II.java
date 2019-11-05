class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Node [] dp = new Node[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new Node(-1);
        }
        return wordBreakUtil(s, 0, wordDict, dp).sentences;
    }
    
    
    public Node wordBreakUtil(String s, int start, List<String> wordDict, Node [] dp) {
        if (start == s.length()) {
            String str = "";
            Node test = new Node(1);
            test.sentences.add(str);
            return test;
        }
        
        if (dp[start].res != -1) {
            return dp[start];
        }

        Node node = new Node(0);
        
        for (int i = start; i <= s.length(); i++) {
            String current = s.substring(start, i);
            if (wordDict.contains(current)) {
                Node temp = wordBreakUtil(s, i, wordDict, dp);
                if (temp.res > 0) {
                    node.res++;
                    for (String str : temp.sentences) {
                        node.sentences.add(str.equals("") ? current : current + " " + str);
                    }
                }
            }
        }
        
        return dp[start] = node;
    }
}

class Node {
    int res;
    List<String> sentences;
    
    public Node(int i) {
        this.res = i;
        this.sentences = new ArrayList<>();
    }
}
