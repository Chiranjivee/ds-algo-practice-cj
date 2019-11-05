public class CountingStrings {
    static int mod = 1_000_000_000 + 7;
	public static long  countStrings(String s){
        int n = s.length();
	    long ans = 0;
	    long greater = 0;

	    for(int i = 0; i < n; ++i) {
            int diff = 'Z' - s.charAt(i);

            // compute how many values you can add to the current num
            // including the current num and the numbers greater than the current num
            // that's why adding one to greater
            ans = (ans + (greater + 1) * diff) % mod;

            // compute how many values are greater than the current value of same length
    		greater = ((greater * 26) % mod + diff) % mod;
    	}
        
        return ans;
	}
}

/**
 * greater = 8, ans = 8, Tere are 8 numbers graeter than 1
 * 
 * curr = 3
 * diff = 6
 * 
 * 13
 * 1 2 3 4 5 6 7 8 9
 * 4, 5, 6, 7, 8, 9
 * 
 */
