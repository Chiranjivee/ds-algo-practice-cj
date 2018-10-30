/**
 * Program to figure out the number 
 * of possible unique binary search tree given
 * number of nodes.
 */
class Solution {
    public int numTrees(int n) {
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
                result[i] += result[a] * result[b];    
                a--;
                b++;
            }
            
            i++;
        }
        
        return result[n];
    }
}
