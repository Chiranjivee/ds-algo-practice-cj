public class CheckAB {

	public static boolean checkAB(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        if (input.charAt(0) != 'a') return false;
        return checkABUtil(input.substring(1), "a");
    }

    public static boolean checkABUtil(String input, String prev) {
        if (input.length() == 0) {
            return true;
        }

        if ((prev == "a" || prev == "bb") && isPrefixA(input)) {
          	return checkABUtil(input.substring(1), "a");
        } else if (prev == "a" && isPrefixBB(input)) {
          	return checkABUtil(input.substring(2), "bb");    
        }
        return false;
    }
  
  	private static boolean isPrefixBB(String input) {
      	return 
			input.length() >= 2 &&
          	input.charAt(0) == 'b' &&
          	input.charAt(1) == 'b';
    }
  
  	private static boolean isPrefixA(String input) {
      	return input.charAt(0) == 'a';
    }
}
