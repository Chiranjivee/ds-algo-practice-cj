class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int [] res = new int [num_people];
        
        int idx = 0;
        int candy = 1;
        while (candies > 0) {
            res[idx++ % num_people] += Math.min(candy, candies);
            candies -= candy++;
        }
        return res;
    }
}
