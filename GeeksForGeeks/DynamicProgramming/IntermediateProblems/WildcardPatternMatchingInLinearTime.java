class WildCardPatternMatching {
    static boolean strmatch(char txt[], char pat[], int n, int m) {

        if (m == 0) return (n == 0);

        // step-1 : 
        // initailze markers : 
        int i = 0, j = 0, index_txt = -1, index_pat = -1;

        while (i < n) {
            if (j < m && txt[i] == pat[j]) {
                i++;
                j++;
            }

            // For step - (3) 
            else if (j < m && pat[j] == '?') {
                i++;
                j++;
            }

            // For step - (4) 
            else if (j < m && pat[j] == '*') {
                index_txt = i;
                index_pat = j;
                j++;
            }

            // For step - (5) 
            else if (index_pat != -1) {
                j = index_pat + 1;
                i = index_txt + 1;
                index_txt++;
            }

            // For step - (6) 
            else {
                return false;
            }
        }

        // For step - (7) 
        while (j < m && pat[j] == '*') {
            j++;
        }

        // Final Check 
        if (j == m) {
            return true;
        }

        return false;
    }
}
