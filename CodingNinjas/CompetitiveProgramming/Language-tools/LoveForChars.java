import java.util.Scanner;

public class LoveForChars {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
      	int [] result = new int[3];
      	in.nextLine();
      	String test = in.nextLine();
      
      	for (int i = 0; i < n; i++) {
          	char c = test.charAt(i);
			switch (c) {
                case 'a': result[0]++; break;
                case 's': result[1]++; break;
                case 'p': result[2]++; break;
            }
        }
      
      
      	StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
          	sb.append(result[i] + " ");
        }
      	sb.setLength(sb.length() - 1);
      	System.out.println(sb.toString());
	}
}
