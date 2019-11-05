class CountNumberOfOnes {
    public static void main(String[] args) {
        int i = 23;
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        System.out.println(count);
    }
}
