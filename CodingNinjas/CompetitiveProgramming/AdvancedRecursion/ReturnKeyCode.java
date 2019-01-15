public class ReturnKeyCode {

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
      	if (n == 0) {
			String[] result = new String[1];
          	result[0] = "";
          	return result;
        }
      
      	int current = n % 10;
      	String[] result = keypad(n / 10);
      	String possiblity = getPossibility(current);
      	String[] newResult = new String[result.length * possiblity.length()];
      	for (int i = 0; i < possiblity.length(); i++) {
          	char c = possiblity.charAt(i);
          	int start = i * result.length;
          	addCurrentCharToResult(newResult, result, start, c);
        }
      	return newResult;
	}

  
  	public static void addCurrentCharToResult(String[] newResult, String[] oldResult, int start, char c) {
      	for (int i = 0; i < oldResult.length; i++) {
          	newResult[start++] = oldResult[i] + c;
        }
    }
  
	public static String getPossibility(int current) {
		switch(current) {
          case 2: return "abc";
          case 3: return "def";
          case 4: return "ghi";
          case 5: return "jkl";
          case 6: return "mno";
          case 7: return "pqrs";
          case 8: return "tuv";
          case 9: return "wxyz";
        }
      	
        return "";
    }
}
