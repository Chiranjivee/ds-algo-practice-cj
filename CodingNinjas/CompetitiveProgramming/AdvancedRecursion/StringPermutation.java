import java.util.List;
import java.util.ArrayList;
public class solution {
	
	public static String[] permutationOfString(String input){
		// Write your code here
      	List<String> result = new ArrayList<>();
		if (input == null || input.length() == 0) {
          	String[] res = new String[0];
            return res;
        }

        showPermutationsUtil(new StringBuilder(input), new StringBuilder(), result);
      	String[] res = new String[result.size()];
      	res = result.toArray(res);
      	return res;
	}	
  
  	public static void showPermutationsUtil(StringBuilder input, StringBuilder permutation, List<String> result) {
        if (input.length() == 0) {
          	result.add(permutation.toString());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            permutation.append(input.charAt(i));
            showPermutationsUtil(
                new StringBuilder(input).deleteCharAt(i),
                permutation,
            	result);
            permutation.deleteCharAt(permutation.length() - 1);
        }
    }
}
