import java.util.Scanner;

public class EvenOddIndexes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
      	int evenSum = 0;
      	int oddSum = 0;
      	
      	for (int i = 0; i < length; i++) {
          	int current = in.nextInt();
          	if (isEven(i) && isEven(current)) {
              	evenSum += current;
            } else if (!isEven(i) && !isEven(current)) {
              	oddSum += current;
            }
        }
      
      	System.out.println(evenSum + " " + oddSum);
	}
  
  	public static boolean isEven(int i) {
      	return i % 2 == 0;
    }
}
