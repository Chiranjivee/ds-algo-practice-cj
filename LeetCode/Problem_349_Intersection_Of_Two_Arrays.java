class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            int found = Arrays.binarySearch(nums2, key);
            if (found >= 0) {
                set.add(key);
            }
        }
        
        int [] res = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int i = 0;
        while(iter.hasNext()) res[i++] = iter.next();
        return res;
    }
}
