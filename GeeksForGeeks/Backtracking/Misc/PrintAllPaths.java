class GraphProblemPrintPaths {
    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

        // Mark the current node 
        isVisited[u] = true;
        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth 
            isVisited[u] = false;
            return;
        }

        // Recur for all the vertices adjacent to current vertex 
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node in path[] 
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node in path[] 
                localPathList.remove(i);
            }
        }

        // Mark the current node 
        isVisited[u] = false;
    }
}
