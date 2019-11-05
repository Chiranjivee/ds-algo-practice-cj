class Solution {
    public int[] pourWater(int[] H, int V, int K) {
        while (V-- > 0) 
            droplet: {
            for (int d = -1; d <= 1; d += 2) {
                int i = K, best = K;
                while (0 <= i+d && i+d < H.length && H[i+d] <= H[i]) {
                    if (H[i+d] < H[i]) best = i + d;
                    i += d;
                }
                
                if (H[best] < H[K]) {
                    H[best]++;
                    break droplet;
                }
            }

            H[K]++;
        }

        return H;
    }
}
