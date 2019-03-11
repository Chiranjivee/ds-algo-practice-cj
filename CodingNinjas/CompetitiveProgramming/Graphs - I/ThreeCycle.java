import java.util.Set;
import java.util.HashSet;

public class ThreeCycle {
    public int solve(int n,int m,int U[],int V[]) {
        int [][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            graph[U[i] - 1][V[i] - 1] = 1;
            graph[V[i] - 1][U[i] - 1] = 1;
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (graph[i][j] == 1) 
                    for (int k = 0; k < n; k++)
                        if (graph[j][k] == 1 && graph[i][k] == 1) 
                            count++;
        return count / 6;
    }
}
