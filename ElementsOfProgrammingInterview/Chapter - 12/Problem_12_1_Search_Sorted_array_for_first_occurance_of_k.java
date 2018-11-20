class FirstKOccurance {

    public int firstKOccurance(int [] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int lastOccurance = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == k) {
                lastOccurance = mid;
                end = mid - 1;
            } else if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return lastOccurance;
    }

    public static void main(String[] args) {
        int [] input = new int [] { 1, 2, 3, 4, 4, 4, 4, 4, 5, 5 , 5, 6 }; 
        FirstKOccurance kOccurance = new FirstKOccurance();
        System.out.println(kOccurance.firstKOccurance(input, 4));
    }
}