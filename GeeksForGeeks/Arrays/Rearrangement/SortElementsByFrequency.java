class SortElementsByFrequency {
    public void sortByFreq(int [] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        // TODO: sort map by values
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();
            while (value-- > 0) {
                list.add(key);
            }
        }

        // copy list to array
    }
}
