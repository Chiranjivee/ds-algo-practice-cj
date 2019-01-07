import java.util.*;

public class ExtractUniqueChars {

	public static String uniqueChar(String str){
		// Write your code here
		Scanner sc = new Scanner(System.in);
      
      	String input = sc.nextLine();
      
      	Set<Character> s = new LinkedHashSet<>();
      	for (int i = 0; i < input.length(); i++) {
          	s.add(input.charAt(i));
        }
      	StringBuilder sb = new StringBuilder();
      	Iterator<Character> iter = s.iterator();
      	while (iter.hasNext()) {
          	sb.append(iter.next());
        }
      	return sb.toString();
	}
}
