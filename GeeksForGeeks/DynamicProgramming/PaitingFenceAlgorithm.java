/**
 * Paint n fences, with k colors with at most 2 adjacent of same color
 * 
 */
class PaintingFenceAlgorithm {

    public int numberOfWaysToPaintFencesWithNAndK(int n, int k) {

        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k * k;
        }

        if (k < 2) {
            return 0;
        }

        if (n == 3) {
            k * (k - 1 + (k - 1) * k);  
        }

        return 
            k * numberOfWaysToPaintFencesWithNAndK(n - 1, k) 
                - 
            (k - 1) * numberOfWaysToPaintFencesWithNAndK(n - 3, k);
    }
}
