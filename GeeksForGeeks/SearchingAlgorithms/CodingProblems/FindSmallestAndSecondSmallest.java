class FindSmallestAndSecondSmallest {
    public void findSmallestAndSecondSmallest(int [] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE - 1;

        for (int x : arr) {
            if (x < min) {
                secondMin = min;
                min = x;
            }
        }

        print(min, secondMin);
    }
}
