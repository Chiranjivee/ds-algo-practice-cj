import java.util.Arrays;

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

    public void rearrangeWithoutExtraSpace(int [] arr) {
        int n = arr.length - 1;
        int maxIdx = n - 1;
        int minIdx = 0;

        int maxElem = arr[n - 1] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
            } else {
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] /= maxElem;
        }

        System.out.println(Arrays.toString(arr));
    }
}
