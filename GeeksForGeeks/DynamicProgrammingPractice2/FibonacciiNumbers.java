class FibonacciiNumbers {
    public void generateNFibonacci(int n) {
        
        int a = 1;
        int b = 1;

        if (n == 1) {
            System.out.println("1");
        } else if (n == 2) {
            System.out.print("1, 1");
        } else if (n > 2) {
            System.out.print("1, 1");
            while (n - 2 > 0) {
                int next = a + b;
                System.out.print(", " + next);
                a = b;
                b = next;
                n--;
            }
            System.out.println("\nDone");
        }
    }

    public static void main(String[] args) {
        FibonacciiNumbers numberGen = new FibonacciiNumbers();
        numberGen.generateNFibonacci(5);
    }
}
