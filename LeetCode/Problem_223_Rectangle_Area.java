class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.max(Math.min(C, G), left);
        int top = Math.max(Math.min(D, H), bottom);
        
        int area3 = Math.abs(left - right) * Math.abs(top - bottom);
        return area1 + area2 - area3;
    }
}
