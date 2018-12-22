class CountCombinations {
    public static int countCombinations(int n, int i) {
        if (i == n) {
            return 1;
        }

        int include = countCombinations(n, i + 1);
        int exclude = countCombinations(n, i + 1);
        return include + exclude;
    }

    public static void main(String[] args) {
        System.out.println("Combinations(4): " + countCombinations(4, 0));
    }
}