class CombinationalSum {
    void findNumbers(int [] ar, int sum, List<List<Integer>> res, List<Integer> r, int i) {
        // If  current sum becomes negative 
        if (sum<0)
            return;

        // if we get exact answer 
        if (sum == 0) {
            res.add(r);
            return;
        }

        // Recur for all remaining elements that 
        // have value smaller than sum. 
        while (i < ar.length && sum - ar[i] >= 0) {

            // Till every element in the array starting 
            // from i which can contribute to the sum 
            r.add(ar[i]); // add them to list 

            // recur for next numbers 
            findNumbers(ar, sum - ar[i], res, r, i);
            i++;

            // remove number from list (backtracking) 
            r.remove(r.size() - 1);
        }
    }
}
