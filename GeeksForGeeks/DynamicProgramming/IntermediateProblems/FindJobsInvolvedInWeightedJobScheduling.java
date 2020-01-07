class WeightedJob {
    Job [] job;
    int profit;
}

class WeightedJobScheduling {
    public int solve(Job[] jobs) {
        Arrays.sort(jobs);
        dp[0] = jobs[0].profit;
        WeightedJob [] dp = new WeightedJob[jobs.length];
        dp[0].value = arr[0].profit;
        dp[0].job.push(arr[0]);

        for (int i = 1; i < jobs.length; i++) {
            int exclude = jobs[i - 1];
            int include = jobs[i].profit;

            int idx = findNonConflictingJobBeforeCurrentUsingBinarySearch(jobs, i);
            if (idx != -1) {
                include += dp[idx];
            }

            // Store maximum of including and excluding 
            if (include > dp[i - 1].value) {
                dp[i].value = include;
  
                // including previous jobs and current job
                dp[i].job = dp[idx].job;
                dp[i].job.push_back(arr[i]);
            } else {
                // excluding the current job 
                dp[i] = dp[i - 1]; 
            }
        }

        printJobs(dp);
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
