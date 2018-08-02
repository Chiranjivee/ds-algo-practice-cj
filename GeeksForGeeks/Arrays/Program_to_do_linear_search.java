class Solution {
    public static void main(String [] args) {
        int [] array = {2, 4, 1, 5, 3};
        Solution sol = new Solution();
        System.out.println("Search 12 in array:" + sol.linearSearch(array, 12));
        System.out.println("Search 1 in array:" + sol.linearSearch(array, 1));
        System.out.println("Search 2 in array:" + sol.linearSearch(array, 2));
        System.out.println("Search 3 in array:" + sol.linearSearch(array, 3));	
    }

    public int linearSearch(int [] array, int key) {
        for (int i = 0 ; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
