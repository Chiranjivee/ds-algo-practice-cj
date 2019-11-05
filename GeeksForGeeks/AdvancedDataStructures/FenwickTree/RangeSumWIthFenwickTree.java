class BIT {
    int size; 
    int [] bit;

    public BIT(int size) {
        this.size = size + 1;
        this.bit = new int [this.size];
    }

    public void constructBITFromArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]);
        }
    }

    public void update(int index, int delta) {
        while (index < size) {
            bit[index] += delta;
            index += Integer.lowestOneBit(index);
        }
    }

    public int get(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= Integer.lowestOneBit(index);
        }
        return sum;
    }

    public int getSumInRange(int low, int high) {
        return get(high + 1) - get(low - 1);
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        BIT bit = new BIT(arr.length);
        bit.constructBITFromArray(arr);
        
        System.out.println("Sum from 0 to 4: " + bit.getSumInRange(0, 4));
        System.out.println("Sum from 0 to 1: " + bit.getSumInRange(0, 1));
        System.out.println("Sum from 0 to 2: " + bit.getSumInRange(0, 2));
        System.out.println("Sum from 3 to 4: " + bit.getSumInRange(3, 4));

        arr[3] += 2;
        bit.update(4, 2);

        System.out.println("Sum from 3 to 4: " + bit.getSumInRange(3, 4));
    }
}