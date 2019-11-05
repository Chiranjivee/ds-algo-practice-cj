class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;

            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    // if same point
                    if((points[j][0] == points[i][0]) && (points[j][1] == points[i][1])){
                        samep++;
                    }
                    
                    // if same x-coordinate, slope will be infinite no need to process this just keep a count 
                    if(points[j][0] == points[i][0]){
                        samex++;
                        continue;
                    }
                    // calculate slope
                    double k = (double)(points[j][0] - points[i][0]) / (double)(points[j][1] - points[i][1]);
                    
                    // if same slope is found increment point count
                    if(hm.containsKey(k)) {
                        hm.put(k,hm.get(k) + 1);
                    } else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            // also, consider the points whose slope was infinite
            result = Math.max(result, samex);
        }
        return result;
    }
}
