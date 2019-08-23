class Solution {
    public String lastSubstring(String str) {
        char [] s = str.toCharArray();
        int n = s.length; 
        int i = 0, j = 1, k = 0;
        while (k < n && i < n && j < n) {
            //cout << i << ", " << j << ", " << k << endl;
            int idx1 = (i+k)%n, idx2 = (j+k)%n;
            if (s[idx1] == s[idx2]) {
                k++;
            } else {
                if (s[idx1] < s[idx2]) {
                    i = i + k + 1;
                } else {
                    j = j + k + 1;
                }
                if (i == j) {
                    i++;
                }
                k = 0;
            } 
        }
        int maxIdx = Math.min(i, j);
        return str.substring(maxIdx);
    }
}
