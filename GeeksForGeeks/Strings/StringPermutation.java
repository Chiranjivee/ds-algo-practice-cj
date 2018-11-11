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
    public void showPermutations(String input) {
        if (input == null || input.length() == 0) {
            return;
        }

        showPermutationsUtil(new StringBuilder(input), new StringBuilder());
    }

    public void showPermutationsUtil(StringBuilder input, StringBuilder permutation) {
        if (input.length() == 0) {
            System.out.println(++count + ">" + permutation);
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
        permutation.showPermutations("abcd");
    }
}