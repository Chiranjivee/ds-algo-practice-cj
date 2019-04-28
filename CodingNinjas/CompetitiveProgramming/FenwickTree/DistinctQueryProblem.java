import java.util.*;

public class DistinctQueryProblem {
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int q = sc.nextInt();
        
        Query [] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            queries[i] = new Query(sc.nextInt(), sc.nextInt(), i);
        }
        in.close();
        Arrays.sort(queries, (a, b) -> a.r - b.r);
        
        int [] bit = new int[n + 1];
        int [] ans = new int[q];
        
        int total = 0;
        int k = 0;

        int [] last = new int[1000001];
        Arrays.fill(last, -1);

        for (int i = 1; i <= n; i++) {
            if (last[arr[i]] != -1) {
                update(last[arr[i]], -1, n, bit);
            } else {
                total++;
            }
            
            update(i, 1, n, bit);
            last[arr[i]] = i;
            
            while (k < q && queries[k].r == i) {
                ans[queries[k].idx] = total - query(queries[k].l - 1, bit);
                k++;
            }
        }
        
        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]);
        }
    }

    static void update(int idx, int val, int size, int [] bit) {
        while (idx <= size) {
            bit[idx] += val;
            idx += idx & (-idx);
        }
    }
    
    static int query(int idx, int [] bit) {
        int count = 0;
        while (idx > 0) {
            count += bit[idx];
            idx -= idx & (-idx);
        }
        return count;
    }
}

class Query {
    int l;
    int r;
    int idx;
    
    public Query(int l, int r, int idx) {
        this.l = l;
        this.r = r;
        this.idx = idx;
    }
}
