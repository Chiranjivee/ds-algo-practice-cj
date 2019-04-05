public class CountingStrings {
    static int mod = 1_000_000_000 + 7;
	public static long  countStrings(String s){
        int n = s.length();
	    long ans = 0;
	    long greater = 0;

	    for(int i = 0; i < n; ++i) {
            int diff = 'Z' - s.charAt(i);
    		ans = (ans + (greater + 1) * diff) % mod;
    		greater = ((greater * 26) % mod + diff) % mod;
    	}
        
        return ans;
	}
}
