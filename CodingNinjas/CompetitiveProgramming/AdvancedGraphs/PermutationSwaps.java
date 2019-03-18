import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int [] permutation = new int[n];
            for (int i = 0; i < n; i++) {
                permutation[i] = sc.nextInt();
            }
            int [] nextPermutation = new int[n];
            
            int [][] graph = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                nextPermutation[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                
                graph[u - 1][v - 1] = 1;
                graph[v - 1][u - 1] = 1;
            }
            
            boolean [] visited = new boolean[n];
            List<List<Integer>> components = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dfs(i, visited, components, graph);
            }
            
            for (List<Integer> component : components) {
                for (Integer e: component) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
            
            // For every component build two sets from each permutation based 
            // on the index defined in the componenet. if the elements in the set are not same
            // print NO, else print YES
        }
	}
    
    public static void dfs(int s, boolean[] visited, List<List<Integer>> components, int[][] graph) {
        if (visited[s]) return;
        
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        int count = 0;
        while (stack.size() != 0) {
            s = stack.pop();
            path.add(s);
            for (int i = 0; i < visited.length; i++) {
                if (i == s) continue;
                if (graph[s][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        stack.push(i);
                    }
                }
            }
        }
        
        components.add(path);
    }
}