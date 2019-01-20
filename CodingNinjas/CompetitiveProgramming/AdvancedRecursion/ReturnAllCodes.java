import java.util.List;
import java.util.ArrayList;
public class ReturnAllCodes {

	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
		// Write your code here
		List<String> res = new ArrayList<>();
      	getCodeUtil(input, new StringBuilder(), res);
      	String[] resArr = new String[res.size()];
		resArr = res.toArray(resArr);
      	return resArr;

	}
  
  	public static void getCodeUtil(String input, StringBuilder temp, List<String> res) {
      	if (input.length() == 0) {
          	res.add(temp.toString());
          	return;
        }	
      
      	int oneDigit = Character.getNumericValue(input.charAt(0));
      	temp.append(getChar(oneDigit));
      	getCodeUtil(input.substring(1), temp, res);
      	temp.setLength(temp.length() - 1);
      	
      	
      	if (input.length() >= 2) {
          	int twoDigit = 10 * oneDigit + Character.getNumericValue(input.charAt(1));
          	if (twoDigit > 26) {
              	return;
            }
          	temp.append(getChar(twoDigit));
          	getCodeUtil(input.substring(2), temp, res);
	        temp.setLength(temp.length() - 1);
        }
    }
  
  	public static char getChar(int x) {
      	return (char) (96 + x);
    }

}
