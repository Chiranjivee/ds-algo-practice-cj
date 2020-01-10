class TilingProblem {

    static int tile = 0;
    public void tileNByNBoardWith1MissingTile(int n) {
        if (n == 2) {
            tile++;
            return;
        }

        tile++;
        return 4 * tileNByNBoardWith1MissingTile(n / 2);
    }
}
