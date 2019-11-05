class Solution {
    private static final int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public int numberOfDays(int Y, int M) {
        return M == 2 && (Y % 4 == 0 && Y % 100 != 0 || Y % 400 == 0) ? 29 : days[M];
    }  
}
