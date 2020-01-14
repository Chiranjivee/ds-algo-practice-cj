class GenerateAllSubsets {
    public void generateSubsets(int index, int [] arr, List<List<Integer>> subsets, List<Integer> subset) {

        if (index == arr.length) {
            subsets.add(subset);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            subset.add(arr[index]);
            generateSubsets(index +  1, arr, subsets, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
