class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        return letterCombinationsUtil(digits, 0, map);
    }
    
    
    public List<String> letterCombinationsUtil(String digits, int idx, Map<Integer, String> map) {
        if (idx == digits.length()) {
            List<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
        
        int currentNum = Character.getNumericValue(digits.charAt(idx));
        String temp = map.get(currentNum);
        
        List<String> res2 = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            List<String> res = letterCombinationsUtil(digits, idx + 1, map);
            for (String s : res) {
                res2.add(temp.charAt(i) + s);    
            }
        }
        return res2;
    }
}
