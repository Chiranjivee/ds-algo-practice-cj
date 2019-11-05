class Solution {
    public int videoStitching(int[][] clips, int T) {
        int count = 0;
        // Sort the clip by starting time.
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int finalEnd = 0;
        int runningEnd = 0;

        while (finalEnd < T) {
            for (int[] clip : clips) {
                // if cannot append current clip to the built sequence
                if (clip[0] > finalEnd) {
                    break;                    
                }

                runningEnd = Math.max(runningEnd, clip[1]);  
            }

            // if st == end here it means we were not able to find a longer length clip
            if (finalEnd == runningEnd) return -1;
            finalEnd = runningEnd; // update start to end
            count++;
        }

        return count;
    }
}
