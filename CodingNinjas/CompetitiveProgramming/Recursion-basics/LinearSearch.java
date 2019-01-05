public class Solution {
	
	public static boolean checkNumber(int input[], int x) {
      	return checkNumUtil(input, x, 0);
	}
  
  	public static boolean checkNumUtil(int input[], int num, int i) {
      	if (i == input.length) {
          	return false;
        }
      	if (input[i] == num) {
          	return true;
        }
      
      	return checkNumUtil(input, num, i + 1);
    }
}
