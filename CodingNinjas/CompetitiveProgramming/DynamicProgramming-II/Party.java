import java.util.Scanner;
import java.util.Arrays;

public class Party {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
      
      	while (true) {
          	int partyBudget = sc.nextInt();
      		int numberOfParties = sc.nextInt();
          
          	if (partyBudget == 0 && numberOfParties == 0) return;
      
      		int [] entryFees = new int[numberOfParties];
      		int [] funOfParty = new int[numberOfParties];
            Node [] nodes = new Node[numberOfParties];

      		for (int i = 0; i < numberOfParties; i++) {
                nodes[i] = new Node();
                nodes[i].fees = sc.nextInt();
                nodes[i].fun = sc.nextInt();
            }
            sc.close();
          
            Arrays.sort(nodes, (a, b) -> a.fees - b.fees);
            for (int i = 0; i < numberOfParties; i++) {
                entryFees[i] = nodes[i].fees;
                funOfParty[i] = nodes[i].fun;
            }
            
          	int sol[][] = knapsackIterative(entryFees, funOfParty, partyBudget, numberOfParties);
            for(int k = 0; k <= partyBudget; k++) {
	            if(sol[numberOfParties][k]==sol[numberOfParties][partyBudget]) {
                    System.out.println(k + " " + sol[numberOfParties][partyBudget]);
                    break;   
                }
            }
        }
	}
  
  	public static int[][] knapsackIterative(int [] weight, int [] value, int maxWeight, int n) {
      	int [][] dp = new int[n + 1][maxWeight + 1];
      	for (int j = 1; j <= n; j++) {
          	for (int i = maxWeight; i >= 0; i--) {
                dp[j][i] = (i >= weight[j - 1]) ?
	                Math.max(dp[j - 1][i], value[j - 1] + dp[j - 1][i - weight[j - 1]]) :
                    dp[j - 1][i];
            }
        }
      	return dp;
    }
}

class Node {
    int fees;
    int fun;
}
