import java.util.Scanner;
import java.util.Arrays;

public class CodersRating {
    static int [] bit = new int[100001];
    
    static void update(int index) {
        while (index <= 100000) {
            bit[index]++;
            index += index & (-index);
        }
    }

    static int query(int index) {
        int value = 0;
        while (index > 0) {
            value += bit[index];
            index -= index & (-index);
        }
        return value;
    }
    
	public static void main(String[] args) {
		// Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Coder [] coders = new Coder[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int idx = i;
            coders[i] = new Coder(x, y, idx);
        }
        
        Arrays.sort(coders, (a, b) -> {
            if (a.x == b.x) {
                return a.y - b.y;
            }
            
            return a.x - b.x;
        });

        int [] ans = new int[n];

        for (int i = 0; i < n; ) {
            int endIndex = i;

            while (endIndex < n && coders[i].x == coders[endIndex].x && coders[i].y == coders[endIndex].y) endIndex++;
            
            for (int j = i; j < endIndex; j++) ans[coders[j].idx] = query(coders[i].y);    
            for (int j = i; j < endIndex; j++) update(coders[j].y);
            i = endIndex;
        }
        
        for (int i = 0; i < n; i++) System.out.println(ans[i]);
	}
}

class Coder  {
    int x; 
    int y;
    int idx;

    public Coder(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}
