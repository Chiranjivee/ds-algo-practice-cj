class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char [] c = word.toCharArray();
            Arrays.sort(c);

            String temp = String.valueOf(c);
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(word);
            map.put(String.valueOf(c), list);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }
}
