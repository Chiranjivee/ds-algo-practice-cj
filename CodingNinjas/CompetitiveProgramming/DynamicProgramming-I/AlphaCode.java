import java.util.Scanner;

public class AlphaCode {

	
	public static void main(String[] args) {
		// Write your code here
      	Scanner sc = new Scanner(System.in);
		while (true) {
          	String input = sc.nextLine();
          	if (input.equals("0")) {
              	break;
            }
          
          	System.out.println(solve(input));
        }
	}
  
  	public static int solve(String input) {
      	if (input.length() == 1) {
          	return 1;
        }
      	int [] res = new int[input.length()];
      	res[0] = 1;
      	
		int num = 
          Character.getNumericValue(input.charAt(0)) * 10 
          	+ Character.getNumericValue(input.charAt(1));
      
      	if (num > 0 && num <= 26) {
          	res[1] = 2;
        } else {
          	res[1] = 1;
        }
      
      	for (int i = 2; i < input.length(); i++) {
          	res[i] = res[i - 1];
          	num = 
          		Character.getNumericValue(input.charAt(i - 1)) * 10 
          			+ Character.getNumericValue(input.charAt(i));
          	if (num > 0 && num <= 26) {
              	res[i] += res[i - 2]; 
            }
        }
      	return res[input.length() - 1];
    }

}