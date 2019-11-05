class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.equals("")) {
            return s;    
        }
        
        boolean ignoreK = false;
        char [] arr = s.toCharArray();
        int rangeStart = 0;
        int rangeEnd = 0;
        while (rangeEnd < s.length()) {
            if (rangeEnd - rangeStart + 1 < k) {
                rangeEnd++;
                continue;
            }
            
            if (!ignoreK) {
                reverse(arr, rangeStart, rangeEnd);   
                ignoreK = true;
            } else {
                ignoreK = false;
            }

            rangeStart = rangeEnd + 1;
            rangeEnd = rangeEnd + 1;
        }
        
        if (!ignoreK) reverse(arr, rangeStart, rangeEnd - 1);   
        return new String(arr);
        
    }
    
    public void reverse(char[] arr, int start, int end) {
        if (start >= arr.length || end >= arr.length) return;
        while (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(char[] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
