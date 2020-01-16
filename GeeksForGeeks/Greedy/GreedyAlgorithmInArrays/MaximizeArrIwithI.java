class Maximize {
    public int maximize(int [] arr) {
        Arrays.sort(arr);
        int i = 0;
        int sum = 0;
        for (int x : arr) {
            sum += (i++ * x);
        }

        return sum;
    }
}
