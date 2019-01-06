import java.util.List;
import java.util.ArrayList;

public class FindIndexes {

	public static int[] allIndexes(int input[], int x) {
		List<Integer> result = new ArrayList<>();
      	allIndexesUtil(input, x, result, 0);
      	int [] resultArr = new int[result.size()];
      	if (result.size() == 0) return resultArr;
      	
      	for (int i = 0; i < resultArr.length; i++) {
          	resultArr[i] = result.get(i);
        }
      	return resultArr;
      	
	}
  
  	public static void allIndexesUtil(int input[], int x, List<Integer> result, int i) {
      	if (input.length == i) {
          return;
        }
      
      	if (input[i] == x) {
          result.add(i);
        }
      
      	allIndexesUtil(input, x, result, i + 1);
    }
}
