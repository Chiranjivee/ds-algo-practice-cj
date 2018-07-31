import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String [] args) {
        String [] input = {"Geeks", "For", "Geek"};
	    Arrays.sort(input, Comparator.comparingInt(String::length));
	    System.out.println("Modified Array:" + Arrays.toString(input));
    }
}