class MultiplyTwoPolynomials {
    static int[] multiply(int A[], int B[], int m, int n) {
        int[] prod = new int[m + n - 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prod[i + j] += A[i] * B[j];
            }
        }

        return prod;
    }

    static void printPoly(int poly[], int n) {
        for (int i = 0; i<n; i++) {
            System.out.print(poly[i]);
            if (i != 0) {
                System.out.print("x^" + i);
            }

            if (i != n - 1) {
                System.out.print(" + ");
            }
        }
    }
}
