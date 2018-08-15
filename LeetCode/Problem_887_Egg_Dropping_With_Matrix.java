class Solution {
    public static void main(String[] args) {
        System.out.println("Answer: " + computeEggDroppingProblem(100, 2));
    }

    public static int computeEggDroppingProblem(int n, int e) {
        int [][] m = new int[e + 1][n + 1];

        // fill the base case for the first egg and all floors
        for (int i = 1; i <= n; i++) {
            m[1][i] = i;
        }

        // start from the second egg and 1st floor
        for (int egg = 2; egg <= e; egg++) {
            for (int floor = 1; floor <= n; floor++) {
                int result = Integer.MAX_VALUE;
                // start from floor 1 and go to current floor.
                for (int f = 1; f <= floor; f++) {
                    result = Math.min(result, 1 + Math.max(m[egg - 1][f - 1], m[egg][floor - f]));
                }
                m[egg][floor] = result;                
            }
        }

        for (int i = 0; i < e + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }

        return m[e][n];
    }
}