class IsSubset {
    static boolean isSubset(int arr1[], int arr2[], int m, int n) {
        HashSet<Integer> hset = new HashSet<>();

        for (int i = 0; i<m; i++) {
            if (!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }

       for (int i = 0; i<n; i++) {
            if (!hset.contains(arr2[i]))
                return false;
        }

        return true;
    }
}
