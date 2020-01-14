class PrintAllPalindromicPartitions {
    public List<List<String>> getPalindromicPartitions(String input, int indx) {
        if (indx == input.length()) {
            return new ArrayList<>();
        }

        StringBuilder current = new StringBuilder();
        for (int i = indx; i < input.length(); i++) {
            if (isPalindrome(current)) {
                List<List<String>> results = getPalindromicPartitions(input, indx + 1);
                for (List<String> res : results) {
                    res.addFirst(current);
                }
                return results;
            }
        }

        return new ArrayList<>();
    }
}
