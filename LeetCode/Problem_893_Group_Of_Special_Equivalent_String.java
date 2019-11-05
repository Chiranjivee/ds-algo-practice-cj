class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        
        for (String a : A) {
            int [] map1 = new int[26];
            int [] map2 = new int[26];
            
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    map1[a.charAt(i) - 'a']++;
                } else {
                    map2[a.charAt(i) - 'a']++;
                }
            }
            set.add(Arrays.toString(map1) + " " + Arrays.toString(map2));
        }
        
        return set.size();
    }
}
