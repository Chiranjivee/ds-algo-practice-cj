class RearrangeArrayInMaximumMinimumForm {
    // note array is sorted
    public int [] rearrange(int [] arr) {
        int [] temp = new int[arr.length];
        int i = 0; 
        int j = n - 1;
        int turn = 0;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = turn & 1 == 0 ?  arr[j--] : arr[i++];
            turn ^= 1;
        }

        return temp;
    }
}
