public class Solution{	
	static int m = 1_000_000_000 + 7;
  	public static int countTrees(int n) {
        if (n == 0) {
            return 0;
        } else if ( n == 1) {
            return 1;
        } 
        
        int result [] = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        
        int i = 2;
        while (i <= n) {
            int a = i - 1;
            int b = 0;
            while (b < i) {
              	result[i] = ((result[i] % m) + (((result[a] % m) * (result[b] % m)) % m ) % m ) % m;
                a--;
                b++;
            }
            
            i++;
        }
        
        return result[n];
    }
}
