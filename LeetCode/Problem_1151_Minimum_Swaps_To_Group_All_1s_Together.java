class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        
        for(int i=0;i<data.length;i++)
        {
            if(data[i] == 1)
            {
                totalOnes++;
            }            
        }
        
        int ones = 0;
        int i=0, j=0; // i is the index of starting point, include i , j is the index of end point, not include j
        int maxOnes = 0;
        
        while(i<data.length&&j<=data.length)
        {
            if(j-i<totalOnes)
            {
			    // if the total length is smaller than totalOnes, just increase j and make sure the length equals to totalOnes
                if(j<data.length)ones += data[j];
                j++;                
            }
            else
            {
			   // In this case, length equals to totalOnes count, so we need to update maxOnes, also increase index i and index j, update ones accordingly.
                maxOnes = Math.max(ones, maxOnes);
                ones-=data[i++];
                
                if(j<data.length)ones += data[j];
                j++;
            }
        }
        
        return totalOnes - maxOnes;
    }
}
