import java.util.Arrays;
class StringPermutation {

    /**
     * Given a string, this method will print the 
     * permutations for the string.
     * a -> a
     * ab -> ab, ba
     * abc -> abc, acb, bac, bca, cab, cba
     * 
     * ab "", -> b "a" -> "" ab 
     *        -> a "b" -> "" ba
     * 
     * abc "", -> bc "a" -> b "ac" -> "" acb
     *                   -> c "ab" -> "" abc
     *         -> ac "b" -> a "bc" -> "" bca
     *                   -> c "ba" -> "" bac
     *         -> ab "c" -> a "cb" -> "" cba
     *                   -> b "ca" -> "" cab
     */ 
    public void showPermutationsForString(String input) {
        System.out.println("Permuting string: " + input);
        if (input == null || input.length() == 0) {
            return;
        }

        showPermutationsUtil(new StringBuilder(input), new StringBuilder());
    }

    public void showPermutationsForArray(char[] input) {
        System.out.println("Permuting array: " + Arrays.toString(input));
        if (input == null || input.length == 0) {
            return;
        }

        showPermutationsUtilArray(input, new StringBuilder(), 0);
    }
    // a, b "" 0 -> a, b "a" 1 -> a, b "ab" 2
    //           -> a, b "b"              -> a, b
    public void showPermutationsUtilArray(char[] input, StringBuilder perm, int position) {
        if (perm.length() == input.length) {
            System.out.println(new String(input));
            return;
        }

        for (int i = position; i < input.length; i++) {
            perm.append(input[i]);
            swap(input, i, position);
            showPermutationsUtilArray(input, perm, ++position);
            swap(input, i, --position);
            perm.deleteCharAt(perm.length() - 1);
        }
    }

    public void swap(char [] input, int x, int y) {
        char temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    public void showPermutationsUtil(StringBuilder input, StringBuilder permutation) {
        if (input.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            permutation.append(input.charAt(i));
            showPermutationsUtil(
                new StringBuilder(input).deleteCharAt(i),
                permutation);
            permutation.deleteCharAt(permutation.length() - 1);
        }
    }

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        permutation.showPermutationsForString("ab");
        permutation.showPermutationsForArray("ab".toCharArray());
    }
}