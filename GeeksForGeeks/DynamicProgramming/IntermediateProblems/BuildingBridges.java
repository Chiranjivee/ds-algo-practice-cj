class BuildingBridges {
    int maxBridges(CityPairs values[], int n) {
        int lis[] = ne int[n];
        for (int i = 0; i<n; i++)
            lis[i] = 1;
    
        // sort based on south cordinates
        Arrays.sort(values);
    
        // logic of longest increasing subsequence 
        // applied on the northern coordinates 
        for (int i = 1; i<n; i++)
            for (int j = 0; j<i; j++)
                if (values[i].north >= values[j].north &&
                    lis[i]<1 + lis[j])
                    lis[i] = 1 + lis[j];
    
        int max = lis[0];
        for (int i = 1; i<n; i++)
            if (max<lis[i])
                max = lis[i];
    
        // required number of bridges 
        // that can be built         
        return max;
    }
}
