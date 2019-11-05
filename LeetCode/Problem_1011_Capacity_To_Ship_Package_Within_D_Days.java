class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int totalWeight = 0;
        for (Integer w : weights) totalWeight += w;

        int start = 1;
        int end = totalWeight;
        int ans = 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            boolean res = canShipWithMidWeight(mid, weights, D);
            if (res) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean canShipWithMidWeight(int maxWeight, int[] weights, int D) {
        
        int res = 0;
        
        int currentDayWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (currentDayWeight + weights[i] <= maxWeight) {
                currentDayWeight += weights[i];
            } else {
                
                currentDayWeight = 0;
                res++;
                if (weights[i] > maxWeight) {
                    return false;
                }
                
                if (currentDayWeight + weights[i] <= maxWeight) {
                    currentDayWeight += weights[i];
                }
            }
        }
        res++;
        
        return res <= D;
    }
}
