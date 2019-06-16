class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String [] words = text.split(" ");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first)) {
                if (words[i + 1].equals(second)) {
                    result.add(words[i + 2]);
                }
            }
        }

        String [] resultArr = new String[result.size()];
        int i = 0;
        for (String temp : result) {
            resultArr[i++] = temp;
        }

        return resultArr;
    }
}
