class Solution {
    public int maxScoreSightseeingPair(int[] A) {
         int ans =A[0];
        int prevBestIdx =0;
        for(int j=1;j<A.length;j++){
            ans = Math.max(ans, A[prevBestIdx]+prevBestIdx+A[j]-j);
            if(A[prevBestIdx ]+prevBestIdx <A[j]+j){
                prevBestIdx =j;
            }
        }
        return ans;
    }
}
