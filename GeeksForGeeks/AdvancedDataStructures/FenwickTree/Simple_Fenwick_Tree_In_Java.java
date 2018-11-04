class BIT {
    int size;
    int [] table;

    public BIT(int size) {
        this.size = size;
        this.table = new int [table];
    }

    public void update(int i, int delta) {
        while (i < size) {
            table[i] += delta;
            i = Integer.lowestOneBit(i);
        }
    }

    int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += table[i];
            i -= Integer.lowestOneBit(i);
        }
        return sum;
    }

    int rangeSum(int i, int j) {
        return sum(j) - sum(i);
    }
}