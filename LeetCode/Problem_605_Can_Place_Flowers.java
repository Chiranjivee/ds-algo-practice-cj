class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0 && n == 1) {
                return true;
            }
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                break;
            }

            if (flowerbed[i] == 1) {
                continue;
            }

            if (canPutFlowerAtI(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }

    boolean canPutFlowerAtI(int[] flowerbed, int i) {
        if (i == 0) {
            return flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[i - 1] == 0;
        }

        return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
    }
}
