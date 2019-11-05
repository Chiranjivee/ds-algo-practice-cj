class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.size() == 3) {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        int key = entry.getKey();
                        int value = entry.getValue();
                        if (value > 0) {
                            map.put(key, value - 1);
                        }
                    }
                    
                    map.entrySet().removeIf(entry -> (entry.getValue() == 0));
                }
            } else {
                map.put(i, 1);
            }
        }
        
        int req = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (isPresentReqTimes(key, nums, req)) {
                result.add(key);
            }
        }

        return result;
    }
    
    private boolean isPresentReqTimes(int key, int [] nums, int req) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                count++;
            }
        }

        return count > req;
    }
}
