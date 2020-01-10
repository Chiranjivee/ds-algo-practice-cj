class SkylineProblem {
    public Strip[] findSkyLine(Building[] buildings, int start, int end) {

        if (start == end) {
            Strip[] skyLine = new Strip[2];
            skyLine[0] = new Strip(buildings[start].left, buildings[start].height);
            skyLine[1] = new Strip(buildings[start].right, 0);
            return skyLine;z
        }    

        int mid = (start + end) / 2;
        Strip[] left = findSkyLine(buildings, start, mid);
        Strip[] right = findSkyLine(buildings, mid + 1, end);
        return mergeSkyLines(left, right);
    }

    private Strip[] mergeSkyLines(Strip[] left, Strip[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        Strip[] resultSkyLine = new Strip[left + right];

        int i = 0; 
        int j = 0;
        int h1 = 0;
        int h2 = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i].left < right[j].left) {
                int x = left[i].left;
                int h1 = left[i].height;

                int maxHeight = Math.max(h1, h2);
                resultSkyLine[k++] = left[i++];
            } else {
                int x = right[j].left;
                int h2 = right[j].height;

                int maxHeight = Math.max(h1, h2);
                resultSkyLine[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            resultSkyLine[k++] = left[i++];
        }

        while (j < rightLength) {
            resultSkyLine[k++] = right[j++];
        }

        return resultSkyLine;
    }
}

class Building {
    int left;
    int right;
    int height;
}

class Strip {
    int left;
    int height;
}
