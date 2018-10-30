/**
 * 
 * Problem 17.1
 * 
 * Write a program to add two numbers with plus operator.
 */
class Solution {
    public static int addNum(int x, int y) {
        if (y == 0) return x;
        int sum = x ^ y;
        int carry = (x & y) << 1;
        return addNum(sum, carry);
    }
    public static void main(String [] args) {
        int x = 2; 
        int y = 3;
        System.out.println("Sum: " + addNum(2, 3));
    }
}
