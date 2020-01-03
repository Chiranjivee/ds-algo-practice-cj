class WeightedJobScheduling {
    public int solve(Job[] jobs) {
        Arrays.sort(jobs);
        dp[0] = jobs[0].profit;
        int [] dp = new int[jobs.length];

        for (int i = 1; i < jobs.length; i++) {
            int exclude = jobs[i - 1];
            int include = jobs[i].profit;

            int idx = findNonConflictingJobBeforeCurrentUsingBinarySearch(jobs, i);
            if (idx != -1) {
                include += dp[idx];
            }

            dp[i] = Math.max(exclude, include);
        }

        return dp[jobs.length - 1];
    }

    int findNonConflictingJobBeforeCurrentUsingBinarySearch(Job[] jobs, int idx) {
        int low = 0;
        int high = idx - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].finishTime <= jobs[idx].startTime) {
                if (jobs[mid + 1].finishTime <= jobs[idx].startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

class Job implements Comparable {
    int startTime;
    int finishTime;
    int profit;

    public int compare(Job j1, Job j2) {
        return j1.finishTime - j2.finishTime;
    }
}
