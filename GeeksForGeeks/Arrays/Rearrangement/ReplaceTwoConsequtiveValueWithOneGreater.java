class ReplaceTwoConsequtiveValueWithOneGreater {
    public void solve(int [] arr) {
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[pos++] = arr[i];

            while (pos > 1 && arr[pos - 2] == arr[pos - 1]) {
                pos--;
                arr[pos - 1]++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
