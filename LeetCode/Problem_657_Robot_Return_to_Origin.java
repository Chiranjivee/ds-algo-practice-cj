class Solution {
    public boolean judgeCircle(String moves) {
        
        char [] movesArr = moves.toCharArray();
        int x = 0; int y = 0;
        for (int i = 0; i < movesArr.length; i++) {
            if (movesArr[i] == 'U') {
                y--;
            } else if (movesArr[i] == 'R') {
                x++;
            } else if (movesArr[i] == 'D') {
                y++;
            } else if (movesArr[i] == 'L') {
                x--;
            }
        }
        
        return x == 0 && y == 0;
    }
}
