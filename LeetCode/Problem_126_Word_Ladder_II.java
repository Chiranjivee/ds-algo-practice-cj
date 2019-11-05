class Solution {
    HashMap<String, List<List<String>>> track;
    HashMap<String, List<String>> paths;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        track = new HashMap<>();
        paths = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashMap<String, Integer> depths = new HashMap<>();
        paths.put(beginWord, new ArrayList<>());
        depths.put(beginWord, 1);
        wordSet.remove(beginWord);
        LinkedList<String> q = new LinkedList<>();
        q.offer(beginWord);
        boolean found = false;
        int depth = 0;
        while (!q.isEmpty() && !found) {
            ++depth;
            int size = q.size();
            // go through the same depth
            for (int count=0; count<size; count++) {
                String parent = q.poll();
                char[] parentC = parent.toCharArray();
                for (int i=0; i<parentC.length; i++) {
                    char c = parentC[i];
                    for (int j='a'; j<='z'; j++) {
                        if (j==c) continue;
                        parentC[i] = (char)j;
                        String candidate = new String(parentC);
                        if (wordSet.contains(candidate)) {
                            List<String> path 
                                = paths.getOrDefault(candidate, new ArrayList<>());
                            path.add(parent);
                            paths.put(candidate, path);
                            depths.put(candidate, depth+1);
                            wordSet.remove(candidate);
                            if (candidate.equals(endWord)) {
                                found = true;
                            } else {
                                q.offer(candidate);
                            }
                        } else {
                            if (depths.containsKey(candidate) 
                                && depths.get(candidate)==depth+1) {
                                paths.get(candidate).add(parent);
                            }
                        }
                    }
                    parentC[i] = c;
                }
            }
        }
        return dfs(endWord);
    }
    
    public List<List<String>> dfs(String endword) {
        List<List<String>> res = new ArrayList<>();
        if (paths.get(endword)==null) return res;
        if (paths.get(endword).size()==0) {
            res.add(new LinkedList<>(Arrays.asList(endword)));
        }
        if (track.containsKey(endword)) {
            return track.get(endword);
        }
        for (String parent:paths.get(endword)) {
            List<List<String>> parents = dfs(parent);
            for (List<String> value:parents) {
                List<String> tmp = new ArrayList<>(value);
                tmp.add(endword);
                res.add(tmp);
            }
        }
        track.put(endword, res);
        return res;
    }
}
