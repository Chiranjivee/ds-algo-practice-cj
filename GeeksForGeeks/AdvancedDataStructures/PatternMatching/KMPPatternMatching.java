import java.util.Arrays;

class KMPPatternMatching {

    int [] preprocess(String pattern) {
        int [] preprocessedArr = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                preprocessedArr[i] = ++j;
            } else {
                if (j == 0) continue;
                j = preprocessedArr[--j];
                i--;
            }
        }
        return preprocessedArr;
    }

    int matchWithKMPAlgorithm(String text, String pattern) {
        int [] preprocessedArr = preprocess(pattern);
        System.out.println(Arrays.toString(preprocessedArr));
        int j = 0; 
        for (int i = 0 ; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(j)) { 
                j++; 
                if (pattern.length() == j) {
                    return i - j + 1; 
                }
            } else {
                if (j == 0) continue;
                j = preprocessedArr[j - 1];
                i--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KMPPatternMatching kmp = new KMPPatternMatching();
        String input = "abxabcabcaby";
        String pattern = "xabc";
        int result = kmp.matchWithKMPAlgorithm(input, pattern);
        System.out.println("Index of abcaby in abxabcabcaby:" + result);
        System.out.println("Substring result: " + input.substring(result, result + pattern.length()));
    }
}