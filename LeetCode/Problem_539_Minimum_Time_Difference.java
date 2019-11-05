class Solution {
    public int findMinDifference(List<String> timePoints) {
        int [] time = new int[timePoints.size()];
        int i = 0;
        for (String timePoint : timePoints) {
            int timeInMinutes = convertToMinutes(timePoint);
            time[i++] = timeInMinutes;
        }
        Arrays.sort(time);
        
        int mm = Integer.MAX_VALUE;
        for (i = 1; i < time.length; i++){
            mm = Math.min(mm, time[i] - time[i-1]);
        }
        
        
        int corner = time[0] + (1440 - time[time.length - 1]);
        return Math.min(mm, corner);

    }
    
    public int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.valueOf(parts[0]) * 60;
        int minutes = Integer.valueOf(parts[1]);
        return hours + minutes;
    }
}
