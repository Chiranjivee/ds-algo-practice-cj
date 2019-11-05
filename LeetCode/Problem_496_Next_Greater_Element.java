import java.util.Stack;

class Solution {

    public int [] nextGreaterELementUsingStack(int [] nums1, int [] nums2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer e : nums2) {
            while (!stack.isEmpty() && stack.peek() < e) {
                map.put(stack.pop(), e);
            }
            stack.push(e);
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        for (int i = 0; i < nums1.length; i++) {
            int res = nums1[i];
            nums1[i] = -1;
            boolean rightOfI = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == res) {
                    rightOfI = true;
                }
                
                if (rightOfI && nums2[j] > res) {
                    nums1[i] = nums2[j];
                    break;
                }   
            }
        }
        return nums1;
    }
}
