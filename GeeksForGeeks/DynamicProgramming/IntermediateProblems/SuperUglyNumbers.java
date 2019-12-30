class SuperUglyNumbers {
    public int generateSuperUglyNumber(int [] primes, int n) {
        int [] ugly = new int[n + 1];
        ugly[1] = 1;
        int [] nextMultipleOfPrime = new int[primes.length];
        int [] nextMultiplierOfPrime = new int[primes.length];

        for (int i = 2; i <= n; i++) {

            int nextUglyNumber = getMinimumFrom(nextMultipleOfPrime);
            for (int j = 0; j < primes.length; j++) {
                if (nextUglyNumber == nextMultipleOfPrime[j]) {
                    nextMultiplierOfPrime[j]++;
                    nextMultipleOfPrime[j] = primes[j] * nextMultiplierOfPrime[j];
                }
            }

            ugly[i] = nextUglyNumber;
        }

        return ugly[n];
    }

    public int getMinimumFrom(int [] arr) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minimum = Math.min(minimum, arr[i]);
        }

        return minimum;
    }
}
