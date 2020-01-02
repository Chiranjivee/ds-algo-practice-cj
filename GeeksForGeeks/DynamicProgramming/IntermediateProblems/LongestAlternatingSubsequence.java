/**
 * 
 * las[i][0] = Length of the longest alternating subsequence 
          ending at index i and last element is greater
          than its previous element
    las[i][1] = Length of the longest alternating subsequence 
          ending at index i and last element is smaller
          than its previous element

    Recursive Formulation:
    las[i][0] = max (las[i][0], las[j][1] + 1); for all j < i and A[j] < A[i] 
    las[i][1] = max (las[i][1], las[j][0] + 1); for all j < i and A[j] > A[i]
 * 
 */
class LongestAlternatingSubsequence {

    public int findLongestAlternatingSeq(int [] arr) {
        int [][] las = new int[2][arr.length];
        Arrays.fill(las[0], 1);
        Arrays.fill(las[1], 1);

        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && las[0][i] < las[1][j] + 1) {
                    las[0][i] = 1 + las[1][j];
                } else if (arr[j] > arr[i] && las[1][i] < las[0][j] + 1) {
                    las[1][i] = 1 + las[0][j];
                }
            }

            res = Math.max(las[0][i], las[1][i]);
        }

        return res;
    }
}
