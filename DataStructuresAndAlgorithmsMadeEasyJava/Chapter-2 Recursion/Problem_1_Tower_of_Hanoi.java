class Solution
{
    public static void main(String[] args)
    {
        towerOfHanoi(3, 'A', 'B', 'C');
    }

    public static void towerOfHanoi(int n, char pegA, char pegB, char pegC)
    {
        if (n == 1) {
            System.out.println("Move from " + pegA + " to " + pegC);
            return;
        }

        towerOfHanoi(n - 1, pegA, pegC, pegB);
        System.out.println("Move from " + pegA + " to " + pegC);
        towerOfHanoi(n - 1, pegB, pegA, pegC);
    }
}
