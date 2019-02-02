import java.util.Scanner;

class ProblemDiscussion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, k));
    }

    public static int solve(int [] arr, int k) {
        int max = findMax(arr);
        max /= 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                arr[i] += k;
            } else {
                arr[i] -= k;
            }
        }
        max = findMax(arr);
        int min = findMin(arr);
        return max - min;
    }
    public static int findMax(int [] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int [] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}