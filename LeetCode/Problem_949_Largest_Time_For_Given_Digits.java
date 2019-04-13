class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> res = permute(A, 0);
        StringBuilder builder = new StringBuilder();
        
        String result = "";
        for (List<Integer> list : res) {
            builder.setLength(0);
            for (Integer e : list) builder.append(e);
            String curr = builder.toString();
            boolean isValidTime = isValid(curr);
            if (isValidTime) {
                result = result.equals("") ? curr : max(curr, result);
            }
        }

        return result.equals("") ? "" : result.substring(0, 2) + ":" + result.substring(2);
    }
    
    public boolean isValid(String s) {
        int h1 = Character.getNumericValue(s.charAt(0));
        int h2 = Character.getNumericValue(s.charAt(1));
        
        int m1 = Character.getNumericValue(s.charAt(2));
        int m2 = Character.getNumericValue(s.charAt(3));
        
        int hour = h1 * 10 + h2;
        int minutes = m1 * 10 + m2;
        
        return hour >= 0 && hour <= 23 && minutes >= 0 && minutes <= 59;
    }
    
    public String max(String s1, String s2) {
        
        int h1 = Character.getNumericValue(s1.charAt(0));
        int h2 = Character.getNumericValue(s1.charAt(1));
        
        int m1 = Character.getNumericValue(s1.charAt(2));
        int m2 = Character.getNumericValue(s1.charAt(3));
        
        int hour = h1 * 10 + h2;
        int minutes = m1 * 10 + m2;

        
        int h3 = Character.getNumericValue(s2.charAt(0));
        int h4 = Character.getNumericValue(s2.charAt(1));
        
        int m3 = Character.getNumericValue(s2.charAt(2));
        int m4 = Character.getNumericValue(s2.charAt(3));
        
        int hour1= h3 * 10 + h4;
        int minutes1 = m3 * 10 + m4;
        
        if (hour == hour1) {
            if (minutes >= minutes1) {
                return s1;
            } else {
                return s2;
            }
        }
        
        
        if (hour > hour1) {
            return s1;
        } else {
            return s2;
        }
        
    }
    
    
    public List<List<Integer>> permute(int [] A, int start) {
        if (start == A.length) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> res1 = new ArrayList<>();
            res.add(res1);
            return res;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < A.length; i++) {
            swap(A, start, i);
            List<List<Integer>> res = permute(A, start + 1);
            for (List<Integer> list : res) {
                list.add(A[start]);
                result.add(list);
            }

            swap(A, i, start);
        }
        
        return result;
    }
    
    public void swap(int [] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
