class WordBreak {
    public List<String> getBreaks(String input, int indx, Trie trie) {
        if (indx == input.length()) {
            return new ArrayList<>();
        }

        StringBuilder prefix = new StrignBuilder();
        for (int i = indx; i < input.length(); i++) {

            prefix.append(input.charAt(i));
            if (trie.containsWord(prefix)) {
                List<String> result = getBreaks(input, indx + 1, trie);
                List<String> newRes = new ArrayList<>();
                for (String res: result) {
                    newRes.add(prefix + " " + res);
                }

                return newRes;
            }
        }

        return new ArrayList<>();
    }
}
