class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        TreeMap<Integer, String[]> userAndSite = new TreeMap<>();
        for (int i = 0; i < timestamp.length; ++i) // sort the user names and corresponding websites by time.
            userAndSite.put(timestamp[i], new String[] { username[i], website[i]});
        Map<String, List<String>> sites = new HashMap<>();
        for (String[] sa : userAndSite.values()) // user and his websites.
            sites.computeIfAbsent(sa[0], l -> new ArrayList<>()).add(sa[1]);
        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        String ans = "";
        for (String user : sites.keySet()) { // for each user, create all tuples and add to a HashSet to prune duplications.
            Set<String> seq = new HashSet<>();
            List<String> l = sites.get(user);
            int sz = l.size();
            for (int i = 0; i < sz; ++i) { // build up tuples.
                for (int j = i + 1; j < sz; ++j) {
                    for (int k = j + 1; k < sz; ++k) {
                        seq.add(l.get(i) + '#' + l.get(j) + '#' + l.get(k));
                    }
                }
            }
            for (String s : seq) {
                count.put(s, count.getOrDefault(s, 0) + 1); // count the number of users visiting a specific tuple.
                if (max < count.get(s) || max == count.get(s) && ans.compareTo(s) > 0) { // update ans;
                    max = count.get(s);
                    ans = s;
                }
            }
        }
        return Arrays.stream(ans.split("#")).collect(Collectors.toList());
 
    }
}
