class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(sb.length()<B.length())
        {
            sb.append(A);
            i++;
        }
        if(sb.toString().contains(B)) return i;
        if(sb.append(A).toString().contains(B)) return i+1;
        return -1;
    }
}
