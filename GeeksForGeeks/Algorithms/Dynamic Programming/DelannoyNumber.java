class DelannoyNumber {
    public static int delannoyNumber(int m, int n) {
        if (m == 0 || n == 0) return 1;
        
        return 
            delannoyNumber(m - 1, n) + 
            delannoyNumber(m - 1, n - 1) + 
            delannoyNumber(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println("DelannoyNumber (3, 3): " + delannoyNumber(1, 1));
    }
}
