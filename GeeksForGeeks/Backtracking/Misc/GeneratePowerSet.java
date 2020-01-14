class GeneratePowerSet {
    public void generatePowerSet(String str) {

        char [] ch = str.toCharArray();
        Arrays.sort(ch);

        generatePowerSetUtil(new String(ch), 0, subsets, subset);
    }

    public void generatePowerSetUtil(String str, int indx, List<String> subsets, String subset) {
        if (indx == str.length()) {
            return;
        }

        subsets.add(subset);
        for (int i = indx; i < str.length(); i++) {
            // include;
            subset += str.charAt(i);
            generatePowerSetUtil(str, indx + 1, subsets, subset);
            subset = subset.substring(0, subset.length() - 1);
        }
    }
}
