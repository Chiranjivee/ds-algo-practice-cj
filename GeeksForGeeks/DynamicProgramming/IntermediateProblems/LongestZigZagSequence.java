class LongestZigZagSequence {
    public int zigZag(int [] arr) {
        int n = arr.length;
        int [][] z = new int[2][n];

        for (int i = 0; i < arr.length; i++) {
            z[0][i] = 1; // length of longest zigzag seq ending at i & last element is greater than prev element
            z[1][i] = 1; // length of longest zigzag seq ending at i & last element is smaller than prev element
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && z[0][i] < z[1][j] + 1) {
                    z[0][i] = 1 + z[1][j];
                }

                if (arr[i] < arr[j] && z[1][i] < z[0][j] + 1) {
                    z[1][i] = 1 + z[1][j];
                }
            }
        }

        res = Math.max(res, Math.max(z[0][i], z[1][i]));
    }
}
