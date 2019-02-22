import java.util.Scanner;

public class MaxSumRectangle {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(maxSumRectangle(mat));
    }

    public static int maxSumRectangle(int[][] mat) {
        int col = mat[0].length;
        int resultSum = Integer.MIN_VALUE;
        for (int left = 0; left < col; left++) {
            int[] kadaneArr = new int[mat.length];
            for (int right = left; right < col; right++) {
                for (int row = 0; row < mat.length; row++) {
                    kadaneArr[row] += mat[row][right];
                }

                int sum = maxSumSubarray(kadaneArr);
                if (sum > resultSum) {
                    resultSum = sum;
                }
            }
        }
        return resultSum;
    }

    public static int maxSumSubarray(int[] a) {
        int maxSoFar = a[0];
        int currMax = a[0];

        for (int i = 1; i < a.length; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
