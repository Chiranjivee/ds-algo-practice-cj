class RearrangeBinaryString {
    public void rearrange(String str) {
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }

        while (countZero > 0 || countOne > 0) {
            for (int j = 0; j < x && count_0 > 0; j++) {
                if (countZero > 0) {
                    System.out.print ("0");
                    countZero--;
                }
            }

            for (int j = 0; j < y && count_1 > 0; j++) {
                if (countOne > 0) {
                    System.out.print("1");
                    countOne--;
                }
            }
        }
    }
}
