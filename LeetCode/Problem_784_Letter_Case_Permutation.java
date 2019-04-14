class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        char [] arr = S.toCharArray();
        subsets(arr, 0, new StringBuilder(), result);
        return result;
    }
    
    public void subsets(char [] nums, int idx, StringBuilder curr, List<String> res) {
        if (idx == nums.length) {
            res.add(curr.toString());
            return;
        }

        if (Character.isDigit(nums[idx])) {
            curr.append(nums[idx]);
            subsets(nums, idx + 1, curr, res);
            curr.setLength(curr.length() - 1);
            return;
        }
        
        curr.append(Character.toLowerCase(nums[idx]));
        subsets(nums, idx + 1, curr, res);
        curr.setLength(curr.length() - 1);
        
        curr.append(Character.toUpperCase(nums[idx]));
        subsets(nums, idx + 1, curr, res);
        curr.setLength(curr.length() - 1);
    }
}
