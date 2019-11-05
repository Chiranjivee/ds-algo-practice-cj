class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // get total node distance b/w stops
        int diff = Math.abs(start - destination);    

        if (diff == 0) return 0;

        int  dist = 0, sum = 0;

        // get total distance
        for (int x: distance) sum += x;

        // switch loop to smaller traversal side
        if (diff > (distance.length - diff)) {    
            int temp = start;
            start = destination;
            destination = temp;
        }

        for (int i=start; (i !=destination); i= (i+1) % distance.length) {
            dist += distance[i];
        }

        return (dist > sum - dist ) ? sum-dist : dist ;
    }
}
