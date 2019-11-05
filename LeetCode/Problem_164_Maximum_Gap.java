class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        int gap = Math.max(1, (max - min) / (n - 1));
        int N = (max - min) / gap + 1;
        Bucket[] buckets = new Bucket[N];
        for (int i = 0; i < N; ++i) {
            buckets[i] = new Bucket();
        }

        for (int num : nums) {
            int p = (num - min) / gap;
            buckets[p].min = Math.min(num, buckets[p].min);
            buckets[p].max = Math.max(num, buckets[p].max);
            buckets[p].used = true;
        }

        int res = Integer.MIN_VALUE;
        int lastMax = min;
        for (int i = 0; i < N; ++i) {
            if (!buckets[i].used) {
                continue;
            }
            res = Math.max(res, buckets[i].min - lastMax);
            lastMax = buckets[i].max;
        }
        return res;
    }
    
    private class Bucket {
        int min;
        int max;
        boolean used;
        
        Bucket() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            used = false;
        }
    }
}
