import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> result = 
            threeSum(new int [] {-1, 0, 1, 2, -1, -4});

        for (List<Integer> intList : result) {
            System.out.println(intList);
        }
    }

    public static List<List<Integer>> threeSum(int [] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException();
        }

        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            intSet.add(nums[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = -1 * (nums[i] + nums[j]);
                if (intSet.contains(temp)) {
                    Integer [] tempArr = new Integer [] {nums[i], nums[j], temp};
                    List<Integer> resultTemp =
                        Arrays.asList(tempArr);
                    result.add(resultTemp);
                    intSet.remove(temp);
                    intSet.remove(nums[i]);
                    intSet.remove(nums[j]);
                }
            }
        }
        return result;
    }
}