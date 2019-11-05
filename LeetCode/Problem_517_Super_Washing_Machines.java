class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length, dressTotal = 0;
        for (int m : machines)
            dressTotal += m;
        if (dressTotal % n != 0)
            return -1;

        int dressPerMachine = dressTotal / n;
        // Change the number of dresses in the machines to
        // the number of dresses to be removed from this machine
        // (could be negative)
        for (int i = 0; i < n; i++)
            machines[i] -= dressPerMachine;

        // currSum is a number of dresses to move at this point,
        // maxSum is a max number of dresses to move at this point or before,
        // m is number of dresses to move out from the current machine.
        int currSum = 0, maxSum = 0, tmpRes = 0, res = 0;
        for (int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            tmpRes = Math.max(maxSum, m);
            res = Math.max(res, tmpRes);
        }
        return res;
    }
}
