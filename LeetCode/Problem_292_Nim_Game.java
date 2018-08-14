class Solution {
    public boolean canWinNim(int numberOfStones) {
        return !(numberOfStones % 4 == 0);
    }
}
