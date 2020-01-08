class IsPathPossible {
    static boolean isPath(int arr[][]) {

        arr[0][0] = 1;

        for (int i = 1; i<5; i++)
            if (arr[0][i] != -1)
                arr[0][i] = arr[0][i - 1];
        for (int j = 1; j<5; j++)
            if (arr[j][0] != -1)
                arr[j][0] = arr[j - 1][0];
    
        // Mark reachable nodes in 
        //  remaining matrix. 
        for (int i = 1; i<5; i++)
            for (int j = 1; j<5; j++)
                if (arr[i][j] != -1)
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
    
        // return yes if right  
        // bottom index is 1 
        return (arr[5 - 1][5 - 1] == 1);
    }
}
