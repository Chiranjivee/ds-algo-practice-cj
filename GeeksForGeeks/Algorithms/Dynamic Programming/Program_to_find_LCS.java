import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String s1 = "aeroplane";
        String s2 = "propane";
        System.out.println("Longest Common Subsequence:" + findLongestCommonSubSequence(s2, s1));
    }

    public static String findLongestCommonSubSequence(String s1, String s2) {
        int [][] mat = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s2.length(); i++) {
            mat[0][i] = 0;
        }

        for (int j = 1; j <= s1.length(); j++) {
            mat[j][0] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c_s1 = s1.charAt(i - 1);
                char c_s2 = s2.charAt(j - 1);
                if (c_s1 == c_s2) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                }
                else {
                    mat[i][j] = max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        System.out.println("Printing bottom up matrix:");
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(mat[i][j] + " " );
	    }
            System.out.println();
        }

        System.out.println("Length of Longest Common SubSeq: " + mat[s1.length()][s2.length()]);
        int row = s1.length();
        int col = s2.length();

        char[] result = new char[mat[row][col]];
        int resultSize = mat[row][col];
        while (col > 0 && row > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {            
		result[resultSize - 1] = s1.charAt(row - 1);
                row--;
                col--;
                resultSize--;
            } else if(mat[row - 1][col] > mat[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }

        return new String(result);
    }

    public static int max(int one, int two) {
        return one > two ? one : two;   
    }
}
