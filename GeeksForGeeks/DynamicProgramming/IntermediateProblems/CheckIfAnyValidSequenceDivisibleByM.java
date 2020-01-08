class CheckIfAnyValidSequenceDivisibleByM {
    static final int MAX = 1000;

    static boolean isPossible(int n, int index, int sum, int M, int arr[], int dp[][]) {

        // Base case 
        if (index == n) {
            // check if sum is divisible by M 
            if ((sum % M) == 0)
                return true;
            return false;
        } else if (sum<0 || sum >= MAX)
            return false;

        // check if the current state  
        // is already computed 
        if (dp[index][sum] != -1) {
            if (dp[index][sum] == 0)
                return false;
            return true;
        }

        // 1.Try placing '+' 
        boolean placeAdd = isPossible(n, index + 1,
            sum + arr[index], M, arr, dp);

        // 2. Try placing '-' 
        boolean placeMinus = isPossible(n, index + 1,
            sum - arr[index], M, arr, dp);

        // calculate value of res for recursive case 
        boolean res = (placeAdd || placeMinus);

        // store the value for res for current  
        // states and return for parent call 
        dp[index][sum] = (res) ? 1 : 0;
        return res;
    }
}
