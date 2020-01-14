class ExpectedValueOfArray {
    static float calc_Expectation(float a[], float n) {
        // Variable prb is for probability of each  
        // element which is same for each element  
        float prb = (1 / n);
    
        // calculating expectation overall 
        float sum = 0;
        for (int i = 0; i<n; i++)
            sum += a[i] * prb;
    
        // returning expectation as sum 
        return sum;
    }
}
