class ReplaceEveryElementWithGreatestElementOnRightSide {
    public void replace(int [] arr) {
        int [] temp = new int[arr.length];

        int maxSoFar = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                temp[i] = -1;
                maxSoFar = Math.max(maxSoFar, arr[i]);
            }

            int tempMax = Math.max(arr[i], maxSoFar);
            temp[i] = maxSoFar;
            maxSoFar = tempMax;
        }
    }
}
