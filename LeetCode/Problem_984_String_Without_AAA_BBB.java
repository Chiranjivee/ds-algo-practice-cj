class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) {
            a = 'b';
            b = 'a';
            i = B;
            j = A;
        }
        while (i-- > 0) {
            res.append(a);
            if (i > j) {
                res.append(a);
                --i;
            }
            if (j-- > 0)
                res.append(b);
        }
        return res.toString();
    }
}
