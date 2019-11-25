/**
 * 
 * Given a set of non-negative integers, and a value sum, 
 * determine if there is a subset of the given set with sum equal to given sum.
 */
class SubsetProblem {

    public boolean isSubsetSum(int [] set, int target) {
        return isSubSetSum(set, 0, target);
    }

    public boolean isSubSetSum(int [] set, int idx, int target) {

        if (target == 0) {
            return true;
        }

        if (idx == set.length && target != 0) {
            return false;
        }

        return 
            isSubSetSum(set, idx + 1, target - set[idx]) 
            || isSubSetSum(set, idx + 1, target);
    }

    public static void main(String[] args) {
        SubsetProblem subsetProblem = new SubsetProblem();

    }
}
