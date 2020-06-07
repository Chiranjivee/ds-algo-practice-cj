class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);    
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);    
            }
        }
        
        for (int i = 0; i < board.length; i+= 3) {
            for (int j = 0; j < board.length; j+= 3) {
                if (!checkBlock(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkBlock(char[][] board, int stX, int stY) {
        Set<Character> set = new HashSet<>();
        for (int i = stX; i < stX + 3; i++) {
            for (int j = stY; j < stY + 3; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);    
            }
        }

        return true;
    }
}
