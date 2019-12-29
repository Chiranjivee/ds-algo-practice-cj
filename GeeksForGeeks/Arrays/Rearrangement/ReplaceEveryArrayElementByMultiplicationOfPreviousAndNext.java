class ReplaceEveryArrayElementByMultOfPrevAndNext {
    public void solve(int [] arr) {
        int prev = arr[i];

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = prev * arr[i];
                continue;
            }

            int next= arr[i + 1];
            if (i == 0) {
                arr[i] = prev * next;
                continue;
            }

            int newPrev = arr[i];
            arr[i] = prev * next;
            prev = newPrev;
        }
    }
}
