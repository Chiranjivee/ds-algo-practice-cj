public class solution {
    public static int func(String[] arr, int n, int l, int[] visited, int[] dp) {
        int set = 0;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            set += visited[i];
            if (visited[i] == 1) {
                mask += (int) Math.pow(2, i);
            }
        }

        if (set == 0) {
            return Integer.MAX_VALUE;
        }

        if (set == 1) {
            return 0;
        }

        if (dp[mask] != -1) {
            return dp[mask];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            int first[] = new int[n];
            int second[] = new int[n];
            int cnt1 = 0;
            int cnt2 = 0;

            for (int k = 0; k < n; k++) {
                if (visited[k] == 1 && arr[k].charAt(i) == '1') {
                    first[k] = 1;
                    cnt1++;
                }

                else if (visited[k] == 1 && arr[k].charAt(i) == '0') {
                    second[k] = 1;
                    cnt2++;
                }
            }

            if (cnt1 == set || cnt2 == set) {
                continue;
            }

            for (int k = 0; k < n; k++) {
                if (first[k] == 1) {
                    visited[k] = 0;
                }
            }

            int c1 = func(arr, n, l, visited, dp);
            for (int k = 0; k < n; k++) {
                if (first[k] == 1) {
                    visited[k] = 1;
                }
            }

            for (int k = 0; k < n; k++) {
                if (second[k] == 1) {
                    visited[k] = 0;
                }
            }

            int c2 = func(arr, n, l, visited, dp);
            for (int k = 0; k < n; k++) {
                if (second[k] == 1) {
                    visited[k] = 1;
                }
            }

            if (c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) { }
            else {
                min = Math.min(min, c1 + c2);
            }
        }

        if (min != Integer.MAX_VALUE) {
            min += set;
        }

        return dp[mask] = min;

    }

    public static int minimumTouchRequired(int n, String[] arr) {
        int l = arr[0].length();
        int visited[] = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 1;
        }

        int dp[] = new int[(int) Math.pow(2, n)];
        for (int j = 0; j < (int) Math.pow(2, n); j++) {
            dp[j] = -1;
        }

        return func(arr, n, l, visited, dp);
    }
}