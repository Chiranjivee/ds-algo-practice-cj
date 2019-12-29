import java.util.Arrays;

class ShuffleAnArray {
    Random r = new Random();
    public void solve(int [] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {            
            int random = r.nextInt(0, i + 1);
            swap(arr, i, random);
        }

        System.out.println(Arrays.toString(arr));
    }
}
