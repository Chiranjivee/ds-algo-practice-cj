class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        double digitsReq =  Math.log(N) / Math.log(2);
        ++digitsReq;
        int mask = (1 << (int)digitsReq) - 1;
        return mask - N;
    }
}
