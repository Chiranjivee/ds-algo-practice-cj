class Solution {
    int[] seg;
    //seg[i] is the maximum height in the corresponding range...
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) return res;
        int n = positions.length;
        int[] x = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            int[] pos = positions[i];
            x[2 * i] = pos[0];
            x[2 * i + 1] = pos[0] + pos[1];
        }
        
        Arrays.sort(x);
        int p = 0;
        for (int num : x) {
            if (p == 0 || num != x[p - 1]) {
                x[p++] = num;
            }
        }
        
        int i = 0;
        while ((1 << i) < p - 1) {
            i++;
        }
        
        seg = new int[(1 << (i + 1)) - 1];
        
        for (int[] pos : positions) {
            int x0 = pos[0];
            int x1 = pos[0] + pos[1];
            int index0 = binarySearch(x0, 0, p - 1, x);
            int index1 = binarySearch(x1, 0, p - 1, x) - 1;
            update(index0, index1, pos[1], 0, p - 2, 0);
            int maxH = query(index0, index1, 0, p - 2, 0);
            //make all the segment within index0 and index1 has the same value as maxH...
            consistent(index0, index1, maxH, 0, p - 2, 0);
            res.add(seg[0]);
        }
        return res;
    }
    
    private void update(int tl, int tr, int h, int cl, int cr, int index) {
        if (tl <= cl && tr >= cr) {
            seg[index] += h;
            return;
        } else if (tr < cl || tl > cr) {
            return;
        } else {
            int mid = cl + (cr - cl) / 2;
            update(tl, tr, h,  cl, mid, 2 * index + 1);
            update(tl, tr, h,  mid + 1, cr, 2 * index + 2);
            seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
        }
    }
    
    private int query(int tl, int tr, int cl, int cr, int index) {
        if (tl <= cl && tr >= cr) {
            return seg[index];
        } else if (tr < cl || tl > cr) {
            return 0;
        } else {
            int mid = cl + (cr - cl) / 2;
            return Math.max(query(tl, tr, cl, mid, 2 * index + 1),
                            query(tl, tr, mid + 1, cr, 2 * index + 2));
        }
    }
    
    private void consistent(int tl, int tr, int h, int cl, int cr, int index) {
        if (tl <= cl && tr >= cr) {
            seg[index] = h;
            if (cl == cr) {
                return;
            }
        } else if (tr < cl || tl > cr) {
            return;
        } 
        int mid = cl + (cr - cl) / 2;
        consistent(tl, tr, h, cl, mid, 2 * index + 1);
        consistent(tl, tr, h, mid + 1, cr, 2 * index + 2);
        seg[index] = Math.max(seg[2 * index + 1], seg[2 * index + 2]);
        //need to update the parent too...
    }
    
    private int binarySearch(int num, int lo, int hi, int[] nums) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == num) return mid;
            if (nums[mid] > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
