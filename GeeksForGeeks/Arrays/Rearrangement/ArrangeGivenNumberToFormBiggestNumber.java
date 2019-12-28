import java.util.Arrays;

class ArrangeGivenNumbersToFormBiggestNumbers {
    public static void arrangeGivenNumbersToFormBiggerNumber(String [] arr) {
        Arrays.sort(arr, (a, b) -> {
            int optionOne = Integer.parseInt(a + b);
            int optionTwo = Integer.parseInt(b + a);
            if (optionOne > optionTwo) {
                return -1;
            } else if (optionTwo > optionOne) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String [] args) {
        arrangeGivenNumbersToFormBiggerNumber(new String [] {"54", "546", "548", "90", "60"});
    }
}
