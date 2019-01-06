import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.HashMap;

/**
 * Sample input: Abhishek harshit Ayush harshit Ayush Iti Deepak Ayush Iti
 * Sample output: 
 * harshit 2
 * Ayush 3
 * Iti 2
 * 
 * Sample input: abhishek cj
 * Sample output: -1
 */
public class DifferentNames {
	public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
      	String input = sc.nextLine();
		Map<String, Integer> nameToCount = new LinkedHashMap<>();
      
      	String[] names = input.split(" ");
      
		Set<String> result = new LinkedHashSet<>();
      	for (int i = 0; i < names.length; i++) {
			if (!nameToCount.containsKey(names[i])) {
              nameToCount.put(names[i], 1);
            } else {
              int currentCount = nameToCount.get(names[i]);
              nameToCount.put(names[i], currentCount + 1);
	          result.add(names[i]);                
            }
        }
      
      	if (result.size() == 0) {
          	System.out.println(-1);
          	return;
        } else {
          	for (String name : result) {
              	System.out.println(name + " " + nameToCount.get(name));
            }
        }
	}
}
