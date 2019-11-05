class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.equals("")) {
            List<List<String>> result = new ArrayList<>();
            List<String> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        return partitionUtil(s, 0);
    }
    
    public List<List<String>> partitionUtil(String s, int idx) {
        if (idx == s.length()) {
            List<List<String>> result = new ArrayList<>();
            List<String> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        
        List<List<String>> result = new ArrayList<>();
        for (int i = idx; i < s.length(); i++) {
            String stemp = s.substring(idx, i + 1);
            if (isPalindrome(stemp)) {
                List<List<String>> tempResult = partitionUtil(s, i + 1);
                for (List<String> list : tempResult) {
                    list.add(0, stemp);
                    result.add(list);
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        return true;
        
    }
}
