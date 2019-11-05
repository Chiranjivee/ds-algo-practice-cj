class FindHI {
    public static void main(String[] args) {
        System.out.println(countHiRecursiveHelper("hi"));
        System.out.println(countHiRecursiveHelper("xhi"));
        System.out.println(countHiRecursiveHelper("hixhi"));
        System.out.println(countHiRecursiveHelper("xhihihix"));
    }

    static int countHiRecursiveHelper(String input) {
        if (input.length() == 1) return 0;
        return countHiRecursive(input, 1, 0, 0, false);
    }

    static int countHiRecursive(String s, int i, int lastCharIdx, int count, boolean seenXBeforeH) {

        int thisCount = 0;

        if (i >= s.length()) return count;
        if (s.charAt(i) == 'i' && s.charAt(lastCharIdx) == 'h' && !seenXBeforeH) {
            thisCount++;
        } else if (s.charAt(i) == 'h') {
            seenXBeforeH = s.charAt(i - 1) == 'x';
            lastCharIdx = i;
        }

        return countHiRecursive(s, i + 1, lastCharIdx, count + thisCount, seenXBeforeH);
    }

    static int countHIIterative(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return 0;

        char lastChar = s.charAt(0);
        boolean seenXBeforeH = false;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'i' && lastChar == 'h' && !seenXBeforeH) {
                count++;
            } else if (s.charAt(i) == 'h') {
                seenXBeforeH = s.charAt(i - 1) == 'x';
                lastChar = s.charAt(i);
            }
        }

        return count;
    }
}
