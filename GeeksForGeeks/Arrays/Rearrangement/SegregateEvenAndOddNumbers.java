class SegregateEvenAndOddNumbers {
    // have even numbers first then odd numbers
    public void solve(int [] arr) {
        int n = arr.length;

        int j = 0;
        int i = -1
        while (j != n) {
            if (arr[j] % 2 == 0) {
                i++;
                swap(arr, i, j);
            }   
        }

        System.out.println(Arrays.toString(arr));
    }
}
