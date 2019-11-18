/**
 * Bell numbers are defined as the number of ways to partitions a set.
 * 
 * It could be defined as sum of stirling numbers i.e. SumOf {S(n, k)} where k goes from 1 to n.
 * 
 * Then Bell(n, k) counts the number of partitions of the set {1, 2, …, n + 1} in which the element 
 * k + 1 is the largest element that can be alone in its set.
 * 
 */
class BellNumbers {

    public static int bellNumber(int n) {

        int [][] bellTriangle = new int[n + 1][n + 1];

        bellTriangle[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            bellTriangle[i][0] = bellTriangle[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bellTriangle[i][j] = bellTriangle[i - 1][j - 1] + bellTriangle[i][j - 1];
            }
        }

        return bellTriangle[n][n];
    }


    public static void main(String[] args) {
        
        System.out.println(BellNumbers.bellNumber(5));
    }
}
