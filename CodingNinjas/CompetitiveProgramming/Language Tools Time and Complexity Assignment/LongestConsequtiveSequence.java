import java.util.*;

public class LongestConsequtiveSequence {

	public static ArrayList<Integer> longestSubsequence(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int maxCount = 0;
		int maxElem = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int left = arr[i] - 1;
			if (!set.contains(left)) {
				int current = arr[i];
				int tempCount = 0;
				while (set.contains(current)) {
					current++;
					tempCount++;
				}

				if (maxCount < tempCount) {
					maxCount = tempCount;
					maxElem = arr[i];
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		result.add(maxElem);

		for (int i = 1; i < maxCount; i++) {
			result.add(++maxElem);
		}

		return result;
	}
}
