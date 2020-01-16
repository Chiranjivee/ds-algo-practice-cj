class FindPivot {
    public int findPivot(int [] arr) {
        int [] leftMax = new int[arr.length];
        int [] rightMin = new int[arr.length];

        leftMax[0] = arr[0];
        rightMin[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (leftMax[i] < arr[i] && rightMin[i + 1] > arr[i]) {
                return i;
            }

            rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
        }

        return -1;
    }
}
