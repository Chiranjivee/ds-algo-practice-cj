class RabinKarpMatching {

    public double getHashForPattern (String pattern) {
        double hash = 0;
        int primeNumber = 3;
        int power = 0;
        for (int i = 0; i < pattern.length(); i++ , power++) {
            int tempChar = (int) pattern.charAt(i);
            hash += tempChar * Math.pow(primeNumber, power);
        }
        return hash;
    }

    public double getRollingHash(String text, int start, int end, double hash) {
        if (start == 0) {
            return getHashForPattern(text.substring(start, end + 1));
        }

        hash -= (int) text.charAt(start - 1);
        hash /= 3;
        hash += (int) text.charAt(end) * Math.pow(3, end - start);
        return hash;
    }

    public int rabinKarpMatcher(String text, String pattern) {
        if (pattern.length() > text.length() || pattern.length() == 0) {
            return -1;
        }

        double patternHash = getHashForPattern(pattern);
        double textRollingHash = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            String sub = text.substring(i, i + pattern.length());
            textRollingHash = getRollingHash(text, i, i + pattern.length() - 1, textRollingHash);
            if (textRollingHash != patternHash) {
                continue;
            }
            
            if (sub.equals(pattern)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RabinKarpMatching karpMatching = new RabinKarpMatching();
        
        System.out.println("Index of test in This: " +
            karpMatching.rabinKarpMatcher("This", "test"));

        System.out.println("Index of sample in This is a sample.: " +
            karpMatching.rabinKarpMatcher("This is a sample.", "sample"));

    }
}