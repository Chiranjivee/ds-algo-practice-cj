import java.util.Arrays;

class LIS {
    public static void main(String[] args) {
        int [] input = new int [] { 2 , 2, 3 };

        int [][] LIS = new int[input.length][input.length];
        for (int i = 0; i < LIS.length; i++) {
            LIS[i][i] = 1;
        }

        for (int i = input.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < input.length; j++) {
                int sizeOfPrevLis = LIS[i + 1][j];
                int startElementOfPreviousLIS = input[i + 1];
                int startElementOfCurrentLIS = input[i];
                if (startElementOfCurrentLIS < startElementOfPreviousLIS) {
                    LIS[i][j] = sizeOfPrevLis + 1;
                } else {
                    LIS[i][j] = sizeOfPrevLis;
                }
            }
        }

        System.out.println("Input array is: " + Arrays.toString(input));
        System.out.println("LIS size is: " + LIS[0][input.length - 1]);
    }
}
