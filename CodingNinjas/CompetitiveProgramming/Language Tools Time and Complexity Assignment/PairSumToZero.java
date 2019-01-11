import java.util.*;

public class PairSumToZero {
	public static void PairSum(int[] input, int size) {
		Map<Integer, Integer> intToCount = new HashMap<>();
      	Map<Integer, Integer> negIntToCount = new HashMap<>();
      	for (int i = 0; i < size; i++) {
          	if (input[i] > 0) {
              	if (intToCount.containsKey(input[i])) {
                	int count = intToCount.get(input[i]);  
                  	intToCount.put(input[i], count + 1);
                } else {
                	intToCount.put(input[i], 1);
                }
            } else {
              	if (negIntToCount.containsKey(input[i])) {
                	int count = negIntToCount.get(input[i]);  
                  	negIntToCount.put(input[i], count + 1);
                } else {
                  	negIntToCount.put(input[i], 1);
                }
            }
        }

      	for (Map.Entry<Integer, Integer> entry : negIntToCount.entrySet())
		{
    		int current = entry.getKey();
          	int currentCount = entry.getValue();
          	
          	int counterPart = current * -1;
          	if (intToCount.containsKey(counterPart)) {
            	int counterPartCount = intToCount.get(counterPart);
          		int totalCount = currentCount * counterPartCount;
          		for (int i = 0; i < totalCount; i++) {
	              	System.out.println(current + " " + counterPart);
	            }  
            }
		}
	}
}
