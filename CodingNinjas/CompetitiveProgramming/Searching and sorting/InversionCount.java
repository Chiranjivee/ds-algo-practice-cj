import java.util.Arrays;
public class InversionCount {
	
	long solve(int[] A,int n){
		
		//Write your code here.
		if (n == 0 || n == 1) {
            return 0;
        }
        return solveDivide(A, 0, n - 1);
	}
  
  	long solveDivide(int[] A, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        
        long leftInversions = solveDivide(A, start, mid);
        long rightInversions = solveDivide(A, mid + 1, end);
        
        long mergeInversions = solveMerge(A, start, mid, end);
        return leftInversions + rightInversions + mergeInversions;
    }
    
    long solveMerge(int[] A, int start, int mid, int end) {
        long mergedInversions = 0;
        int [] leftArray = Arrays.copyOfRange(A, start, mid + 1);
        int [] rightArray = Arrays.copyOfRange(A, mid + 1, end + 1);
        
        int leftRunner = 0;
        int rightRunner = 0;
        int mergedRunner = start;
        
        while (leftRunner < leftArray.length || rightRunner < rightArray.length) {
            int left = leftRunner >= leftArray.length ? Integer.MAX_VALUE : leftArray[leftRunner];
            int right = rightRunner >= rightArray.length ? Integer.MAX_VALUE : rightArray[rightRunner];
            
            if (left <= right) {
                leftRunner++;
            } else {
                mergedInversions += (leftArray.length - leftRunner);
                rightRunner++;
            }
            
            A[mergedRunner++] = Math.min(left, right);
        }   
        return mergedInversions;
    }
	
}
