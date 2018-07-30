import java.util.Scanner;

public class GenerateAllSubstringsOfGivenString {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char [] inputAsArray = input.toCharArray();

        for (int i = 0 ; i < inputAsArray.length; i++) {
            for (int j = i; j < inputAsArray.length; j++) {
                for (int k = i; k <=j; k++) {
                    System.out.print(inputAsArray[k]);
                }
                System.out.println();
            }
        }
    }	
}