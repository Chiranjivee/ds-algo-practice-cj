class PositiveElementsAtEvenAndNegativeElementsAtOdd {
    public void rearrange(int [] arr) {
        int positive = 0;
        int negative = 1;


        while (true) {
            while (positive < n && arr[positive] >= 0) {
                positive +=2;
            }

            while (negative < n && arr[negative] < 0) {
                negative +=2;
            }

            if (positive < n && negative < n) {
                swap(arr[positive], arr[negative]);
            } else {
                break;
            }
        }
    }
}
