public class Solution {
    public static void main(String[] args) {
        String[] test = {"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth","././."};
        String[] ex = {"ranynar","././."};
        for (int i = 0; i < test.length; i++) {
            System.out.println("Expected: " + ex[i] + ", Actual: " + findLongestPalindromicSubString(test[i]));
        }
    }
    public static String findLongestPalindromicSubString(String s) {
        if (s == null || s.equals("")) { return ""; };
        if (s.length() == 1) return s;

        int n = s.length();
        int [][] m = new int [n][n];
        boolean [][] truth = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
            truth[i][i] = true;
        }

        int td = n - 1;
        int cd = 1;
        while (cd <= td) {
            int cde = n - cd;
            int i = 0; 
            int j = cd;
            while (i < cde) { 
                if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j)) {
                    truth[i][j] = false;
                    m[i][j] = Math.max(m[i + 1][j], m[i][j - 1]);
                } else {
                    if (j - i - 1 == 0) {
                        truth[i][j] = true;
                        m[i][j] = 2;
                    } else if (truth[i + 1][j - 1]) {
                        truth[i][j] = true;
                        m[i][j] = Math.max(m[i + 1][j], m[i][j - 1]) + 2;
                    } else {
                        truth[i][j] = false;
                        m[i][j] = Math.max(m[i + 1][j], m[i][j - 1]);
                    }
                }
                i++; j++;
            } 
            cd++;
        }	
        
        int r_row = 0;
        int r_col = n - 1;
        int result = m[r_row][r_col];
        if (result == 1) return s.substring(0, 1);
        while(result >= m[r_row + 1][r_col] && result >= m[r_row][r_col - 1]) {
            if (result == m[r_row + 1][r_col]) {
                r_row++;
            } else if (result == m[r_row][r_col - 1]) {
                r_col--;
            } else {
                break;
            }
        }
        
        return s.substring(r_row, r_col + 1);
    }
}
