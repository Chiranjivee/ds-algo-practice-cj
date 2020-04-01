class ArrayRearrangement {
    public void rearrange(int [] a) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + (a[a[i]] % n) * n;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] /= n;
        }
    }
}
