class Solution { 
    static int dir = 1;
    public String convert(String s, int numRows) {
        if (s == null || s.equals("")) {
            return "";
        }
        
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        StringBuilder [] builders = new StringBuilder[numRows];
        
        int currentRow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (builders[currentRow] == null) {
                builders[currentRow] = new StringBuilder();
                builders[currentRow].append(s.charAt(i));
                currentRow = getNextRow(currentRow, numRows);
                continue;
            }

            builders[currentRow].append(s.charAt(i));
            currentRow = getNextRow(currentRow, numRows);
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            builder.append(builders[i].toString());
        }

        return builder.toString();
    }
    
    public int getNextRow(int currentRow, int totalRow) {
        int nextRow = currentRow + dir;
        if (nextRow < 0 || nextRow >= totalRow) {
            dir = -dir;
        }
        
        return currentRow + dir;
    }
}
