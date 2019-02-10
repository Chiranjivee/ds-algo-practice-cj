import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  final static int MOD = 1_000_000_000 + 7;
  // Complete the substrings function below.
  static int substrings(String n) {
    long last = 0, runningSum = 0, a = 0;
    int i = 0;

    while(i < n.length()) {
        int digit = Character.getNumericValue(n.charAt(i));
        int temp = (i + 1) * digit;
        a = (a % MOD * 10) % MOD + temp;
        runningSum = (last % MOD + a % MOD) % MOD;
        last = runningSum;
        i++;
    }
    return (int)(runningSum % MOD);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
      String n = scanner.nextLine();
      int result = substrings(n);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
      bufferedWriter.close();
      scanner.close();
  }
}
