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
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    System.out.println("Adding:" + nums[i] + " " + nums[j] + " "+ nums[k] + " to set.");
                    result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                }
                if (sum < 0) j++;
                if (sum > 0) k--;
            }
        }
       
        return new ArrayList<>(result);
    }
}
