import java.util.*;

public class TellThePositions {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
      	TreeMap<Integer, List<String>> s = new TreeMap<>(Collections.reverseOrder());
      	for (int i = 0; i < n; i++) {
          	String name = in.next();
          	int marks = in.nextInt() + in.nextInt() + in.nextInt();
          	if (s.containsKey(marks)) {
              	s.get(marks).add(name);
            } else {
              	s.put(marks, new ArrayList<>());
                s.get(marks).add(name);
            }
        }
      
      	Set set = s.entrySet();
    	Iterator iter = set.iterator();
      	int i = 0;
      	while (iter.hasNext()) {
        	Map.Entry me = (Map.Entry) iter.next();
			List<String> names = (List<String>) me.getValue();
			for (String name : names) System.out.println(++i + " " + name);
        }
	}
}

class Student {
  	String name;
  	int marks;
  	
  	public Student(String name, int marks) {
      	this.name = name;
      	this.marks = marks;
    }
}