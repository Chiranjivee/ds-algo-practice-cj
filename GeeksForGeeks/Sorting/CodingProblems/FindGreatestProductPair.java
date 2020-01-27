class FindGreatestProductPair {
    static int findGreatest(int arr[], int n) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i<n; i++) {
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], m.get(arr[i]));
            }
        }

        Arrays.sort(arr);
    
        for (int i = n - 1; i > 1; i--) {
            // For every element, check if there is another 
            // element which divides it. 
            for (int j = 0; j<i &&
                arr[j]<= Math.sqrt(arr[i]); j++) {
                if (arr[i] % arr[j] == 0) {
                    int result = arr[i] / arr[j];
    
                    // Check if the result value exists in array 
                    // or not if yes the return arr[i] 
                    if (result != arr[j] &&
                        m.get(result) == null || m.get(result) > 0) {
                        return arr[i];
                    }
    
                    // To handle the case like arr[i] = 4 
                    // and arr[j] = 2 
                    else if (result == arr[j] && m.get(result) > 1) {
                        return arr[i];
                    }
                }
            }
        }

        return -1;
    }
}
