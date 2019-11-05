class Solution {
    public int count_abbrlen(int abbr, int m) {
        // Consecutive 0's is a number, each 1 is a letter
        int len = 0;
        for(int i = 0; i < m; i++) {
            int bit = (abbr >> i) & 1;
            if(bit == 1) {
                len++;
            }
            else if(bit == 0 && (((abbr >> (i+1) & 1) == 1) || i ==  m -1)) {
                len++;
            }
        }
        return len;
    }

    public boolean has_conlict(String target, String word, int abbr) {
        int m = target.length();
        for(int i = 0; i < word.length(); i++) {
            int bit = (abbr >> i) & 1;
            if(bit == 0) continue;
            if(target.charAt(m - i - 1) != word.charAt(m - i - 1)) return false;
        }
        return true;
    }

    public String generate_abbrstr(String target, int abbr) {
        int m = target.length();
        // Create abbr from binary string
        String sb = "";
        int num = 0;
        for(int k = 0; k < m; k++) {
            int bit = (abbr >> k) & 1;
            if(bit == 1) {
                if(num > 0) sb = Integer.toString(num) + sb;
                sb = target.charAt(m - k - 1) + sb;
                num = 0;
            }
            else {
                num++;
            }
        }
        if(num > 0) sb = Integer.toString(num) + sb;
        return sb;
    }
    public String minAbbreviation(String target, String[] dictionary) {
        int m = target.length(), n = dictionary.length;
        // Try each possible length, from small to big one
        for(int len = 1; len <= m; len++) {
            //System.out.println("len: " + Integer.toString(len));
            // For each length, enumerate all binary strings
            for(int i = 0; i < 2 << (m - 1); i++) {
                int abbr_len = count_abbrlen(i, m);
                if(abbr_len == len) {
                    //System.out.println("i: " + Integer.toBinaryString(i));
                    boolean conflict = false;
                    for(String word : dictionary) {
                        if(word.length() != m) continue;
                        if(has_conlict(target, word, i)) {
                            conflict = true;
                            break;
                        }
                    }
                    // If no conflict found between any word in dict and abbr i, generate a abbr of target using abbr i
                    if(!conflict) {
                        return generate_abbrstr(target, i);
                    }
                }
            }
        }
        return "";
    }
}
