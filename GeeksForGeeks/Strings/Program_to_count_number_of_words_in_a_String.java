class Solution {
    public static void main(String[] args) {
	String [] input = {"  This is a   test input ","test","  test","test ", "", " "};
	int [] expCount = {5, 1, 1, 1, 0, 0};
	Solution solution = new Solution();
        for (int i = 0; i < input.length; i++) {
            System.out.println("Word Count: " + solution.countWordInString(input[i]) + ", Expected Count: " + expCount[i]); 
        }
    }

    public int countWordInString(String input) {
        int startWord = -1;
        int endWord = -1;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && startWord == -1) {
                startWord = i;
                endWord = i;
            } else if (c == ' ' && startWord == -1) {
                continue;
            } else if (c != ' ' && startWord != -1) {
                endWord++;
            } else if (c == ' ' && endWord != -1) {
                // A word has been found
                count++;
                startWord = -1;
                endWord = -1;
            }
        }
        if (endWord - startWord != 0) {
            count++;
        }
        return count;
    } 
}