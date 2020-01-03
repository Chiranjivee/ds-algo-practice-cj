class WeightedJobScheduling {
    public int solve(Job[] jobs) {
        Arrays.sort(jobs);
        dp[0] = jobs[0].profit;
        int [] dp = new int[jobs.length];

        for (int i = 1; i < jobs.length; i++) {
            int exclude = jobs[i - 1];
            int include = jobs[i].profit;

            int idx = findNonConflictingJobBeforeCurrent(jobs, i);
            if (idx != -1) {
                include += dp[idx];
            }

            dp[i] = Math.max(exclude, include);
        }

        return dp[jobs.length - 1];
    }

    int findNonConflictingJobBeforeCurrent(Job[] jobs, int idx) {
        int res = -1;
        for (int i = 0; i < idx; i++) {
            if (jobs[i].finishTime < jobs[idx].startTime) {
                return res;
            }
        }

        return res;
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
