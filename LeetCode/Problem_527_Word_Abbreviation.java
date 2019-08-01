class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        int N = words.size();
        String[] ans = new String[N];
        int[] prefix = new int[N];

        for (int i = 0; i < N; ++i)
            ans[i] = abbrev(words.get(i), 0);

        for (int i = 0; i < N; ++i) {
            while (true) {
                Set<Integer> dupes = new HashSet();
                for (int j = i+1; j < N; ++j)
                    if (ans[i].equals(ans[j]))
                        dupes.add(j);

                if (dupes.isEmpty()) break;
                dupes.add(i);
                for (int k: dupes)
                    ans[k] = abbrev(words.get(k), ++prefix[k]);
            }
        }

        return Arrays.asList(ans);
    }

    public String abbrev(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i+1) + (N - i - 2) + word.charAt(N-1);
    }
}
