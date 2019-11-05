class Solution {
    public int maxRepOpt1(String text) {
        Map<Character, List<int[]>> substrs = new HashMap<>();
		
        int l = 0, r = 0, res = 0, n = text.length();
		// Put all character segments in the hashmap
        while(r < n) {
            while(r < n && text.charAt(r) == text.charAt(l)) r++;  
            res = Math.max(res, r - l);
            substrs.computeIfAbsent(text.charAt(l), k -> new ArrayList<>()).add(new int[]{l, r - 1});
            l = r;
        } 
        
        for(char ch : substrs.keySet()) {
            List<int[]> indexes = substrs.get(ch);
            for(int j = 0; j < indexes.size() - 1; j++) {
                int[] ind1 = indexes.get(j), ind2 = indexes.get(j + 1);
                int len1 = ind1[1] - ind1[0] + 1, len2 = ind2[1] - ind2[0] + 1;				
                if(ind1[1] + 1 == ind2[0] - 1)  // neighbor segments
                    res = Math.max(res, (indexes.size() > 2 ? 1 : 0) + len1 + len2);
                else  // not neighbor, swap a char to the longer one
                    res = Math.max(res, Math.max(len1, len2) + 1);
            }
        }
        return res;
    }
}
