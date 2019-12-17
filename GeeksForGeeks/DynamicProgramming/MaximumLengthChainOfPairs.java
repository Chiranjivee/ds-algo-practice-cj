class MaximumLengthChainOfPairs {

    // Assuming pair arr is sorted based on 'a'.
    public int getMaximumLengthChainOfPairs(Pair [] arr) {
        int [] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public void printMaximumLengthChainOfPairs(Pair [] arr) {
        int [] dp = new int[arr.length + 1];
        Arrays.fill(dp, 1);
        List<List<Pair>> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pairs.add(new ArrayList<>());
            pairs.get(i).append(arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pairs.set(i) = pairs.get(j).append(arr[i]);
                }
            }
        }

        print(pairs);
    }
}

class Pair {
    int a;
    int b;
}
