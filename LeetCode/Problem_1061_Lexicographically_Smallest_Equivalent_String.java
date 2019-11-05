class Solution {
    private int[] parent = new int[26];
    
    public String smallestEquivalentString(String A, String B, String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < parent.length;i++) parent[i] = i;
        for (int i = 0;i < A.length();i++) {
            char ch1 = A.charAt(i);
            char ch2 = B.charAt(i);
            union(ch1 - 'a', ch2 - 'a');
        }
        for (char ch:S.toCharArray()) {
            int p = find(ch - 'a');
            sb.append((char) (p + 'a'));
        }
        return sb.toString();
    }
    
    private void union(int ch1, int ch2) {
        int p1 = find(ch1);
        int p2 = find(ch2);
        if (p1 < p2) {
            parent[p2] = p1; 
        } else {
            parent[p1] = p2;
        }
        
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }   
}
