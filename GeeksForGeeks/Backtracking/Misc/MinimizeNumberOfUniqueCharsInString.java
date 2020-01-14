class MinimizeNumberOfUniqueCharactersInString {
    HashMap<Character, Integer> map;
    static int ans = map.size();
    public void minCountUtil(String a, String b, HashMap<Character, Integer> map, int index) {
        if (index == a.length()) {
            ans = Math.min(ans, map.size());
            return;
        }

        // do a swap
        char aChar = a.charAt(index);
        char bChar = b.charAt(index);
        map.put(aChar, map.get(aChar) - 1);
        a = swapStringACharWithCharBAtIdx(a, b, index);
        map.put(bChar, map.get(bChar) + 1);
        cleanUpMapValuesWithZeroFreq(map);

        minCountUtil(a, b, map, index + 1);

        map.put(bChar, map.get(bChar) - 1);
        map.put(aChar, map.get(aChar) + 1);
        cleanUpMapValuesWithZeroFreq(map);
        minCountUtil(a, b, map, index + 1);
    }
}
