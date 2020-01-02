class NumberOfPalindromicSubsequenceOfLengthKLessThanOrEqualTo3 {
    public int getCount(String s, int k, int [][] l, int [][] r) {
        int ans = 0;
        if (k == 1) {
            ans += s.length();
            return ans;
        }

        if (k == 2) {
            for (int i = 0; i < 26; i++) {
                ans += (l[i][n - 1] * l[i][n - 1])/ 2; 
            }
            return ans;
        }

        if (k == 3) {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 0; j < 26; j++) {
                    ans += l[j][i - 1] * r[j][i + 1];
                }
            }
            return ans;
        }

        return ans;
    }

    public void precompute(int [][] l, int [][] r, String s) {
        int n = s.length();
        l[s.charAt(0) - 'a'][0]++;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                l[j][i] += l[j][i - 1];
            }

            l[s.charAt(i) - 'a'][i]++;
        }

        r[s.charAt(n - 1)][n - 1]++;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                r[j][i] += r[j][i + 1];
            }

            r[s.charAt(i) - 'a'][i]++;
        }
    }
}
