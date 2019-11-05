class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (a.length() != 0) {
                    a.setLength(a.length() - 1);   
                }
            } else {
                a.append(S.charAt(i));
            }
        }
        
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (b.length() != 0) {
                    b.setLength(b.length() - 1);
                }
            } else {
                b.append(T.charAt(i));
            }
        }
        
        return a.toString().equals(b.toString());
    }
}
