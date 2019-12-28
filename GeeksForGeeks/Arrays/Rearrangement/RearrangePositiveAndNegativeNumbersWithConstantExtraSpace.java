class RearrangePositiveAndNegativeNumbersWithConstantExtraSpace {
    public int rearrange(int [] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                continue;
            } else {
                // insert a[i] into correct location
                int temp = a[i];
                int j = i - 1;
                while (j >= 0 && arr[j] >= 0) {
                    arr[j + 1] = arr[j];
                }

                arr[j + 1] = temp;
            }
        }
    }    
}
