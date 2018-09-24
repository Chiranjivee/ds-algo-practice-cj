class Solution {

    public static int findMaxTripletSum(int [] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (max < arr[i] + arr[j] + arr[k]) {
                        max = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        int result = Solution.findMaxTripletSum(arr);
        System.out.println(result);
    }
}
