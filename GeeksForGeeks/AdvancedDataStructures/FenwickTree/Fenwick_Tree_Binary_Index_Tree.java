class BinaryIndexTree {
    int [] tree;
    int treeSize;

    public BinaryIndexTree(int [] arr) {
        treeSize = arr.length + 1;
        tree = new int[treeSize];
    }

    public void constructBIT(int [] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            updateBIT(i, length, arr[i]);
        }
    }

    int getSum(int index)
    {
        if (index >= tree.length) {
            System.out.println("Invalid input");
            return -1;
        }

        int sum = 0;
        index = index + 1;

        while(index>0)
        {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }

    public void updateBIT(int index, int arrLength, int element) {
        index = index + 1;
        while (index <= arrLength) {
            tree[index] += element;
            index += index & (-index);
        }
    }

    public void printFenwickTree() {
        System.out.println("Printing fenwick tree.");
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -1, 9, -8, 17 };
        BinaryIndexTree fenwick = new BinaryIndexTree(arr);
        fenwick.constructBIT(arr);
        fenwick.printFenwickTree();
        System.out.println("Sum from 0 to 3: " + fenwick.getSum(5));
    }
}
