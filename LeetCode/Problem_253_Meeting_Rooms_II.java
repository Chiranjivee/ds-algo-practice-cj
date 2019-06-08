class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
          return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

          // If the room due to free up the earliest is free, assign that room to this meeting.
          if (intervals[i][0] >= allocator.peek()) {
            allocator.poll();
          }

          // If a new room is to be assigned, then also we add to the heap,
          // If an old room is allocated, then also we have to add to the heap with updated end time.
          allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}
