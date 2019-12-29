class SortArrayAccordingToOrderDefinedInAnotherArray {
    public int [] sortByAnotherArray(int [] arr, int [] arr2) {

        int [] temp = new int[arr.length];
        int [] visited = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);
        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            int idx2 = Arrays.binarySearch(temp, arr2[i]);
            arr[idx++] = temp[idx2];
            visited[idx2] = 1;
        }


        for (int i = 0; i < temp.length; i++) {
            if (visited[i] == 0) {
                arr[idx++] = temm[i];
            }
        }

        return temp;
    }
}
