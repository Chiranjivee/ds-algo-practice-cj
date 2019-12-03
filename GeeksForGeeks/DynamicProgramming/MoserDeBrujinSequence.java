/**
 * 
 * Standard recursive sequence:
 * 
 * S(2 * n) = 4 * S(n)
 * S(2 * n + 1) = 4 * S(n) + 1
 */
class MoserDeBrujinSequence {

    int generateNthNumberInSeq(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (n % 2 == 0) {
            return 4 * generateNthNumberInSeq(n / 2);
        } else {
            return 4 * generateNthNumberInSeq(n / 2) + 1;
        }
    }
}
