class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.equals("")) return false;
        int len = s.length();
        List<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i <= (len / 2); i++) {
            if (len % i == 0) {
                divisors.add(i);
            }
        }
        
        for (Integer div : divisors) {
            StringBuilder builder = new StringBuilder();
            String temp = s.substring(0, div);
            // System.out.println("TEMP: " + temp);
            int q = len / div;
            while (q-- > 0) {
                builder.append(temp);
            }
            // System.out.println("builder: " + builder.toString());
            
            if (builder.toString().equals(s)) return true;
        }
        return false;
    }

    public boolean repeatedSubstringPatternApproachTwo(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
