class RearrangeArray {
    public int [] solve(int [] arr) {
        Arrays.sort(arr);
        int i = 0; int j = arr.length - 1;
        int [] ans = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            if (k % 2 == 0) {
                arr[k] = arr[i++];
            } else {
                arr[k] = arr[j--];
            }
        }
        return ans;
    }
}
