class Solution {
    public int numRookCaptures(char[][] b) {
        for (int i = 0; i < b.length; ++i)
            for (int j = 0; j < b[i].length; ++j)
                if (b[i][j] == 'R')
                    return cap(b, i, j, 0, 1) + cap(b, i, j, 0, -1) + cap(b, i, j, 1, 0) + cap(b, i, j, -1, 0);
        return 0;
    }

    int cap(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
            if (b[x][y] == 'p')
                return 1;
            x += dx;
            y += dy;
        }
        return 0;
    }
}