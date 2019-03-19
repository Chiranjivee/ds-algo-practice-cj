import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayList;

public class PermutationSwaps {
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
            
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < n; i++) {
                nextPermutation[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u - 1].add(v - 1);
                graph[v - 1].add(u - 1);
            }
            
            boolean [] visited = new boolean[n];
            List<List<Integer>> components = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dfs(i, visited, components, graph);
            }
            
            boolean success = true;
            // For every component build two sets from each permutation based 
            // on the index defined in the componenet. if the elements in the set are not same
            // print NO, else print YES
            for (List<Integer> component : components) {
                
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                for (Integer e: component) {
                    set1.add(permutation[e]);
                    set2.add(nextPermutation[e]);
                }
                
                if (!set1.equals(set2)) {
                    success = false;
                    break;
                }
            }
            
            System.out.println(success ? "YES" : "NO");
        }
	}
    
    public static void dfs(int s, boolean[] visited, List<List<Integer>> components, ArrayList<Integer>[] graph) {
        if (visited[s]) return;
        
        List<Integer> path = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (stack.size() != 0) {
            s = stack.pop();
            path.add(s);
            for (int i = 0; i < graph[s].size(); i++) {
                int neighbour = graph[s].get(i);
                if (neighbour == s) continue;
                
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }   
            }
        }
        
        components.add(path);
    }
}
