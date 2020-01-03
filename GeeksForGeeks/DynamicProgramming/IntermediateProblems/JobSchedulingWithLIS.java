class WeightedJobScheduling {
    public int solve(Job[] jobs) {
        Arrays.sort(jobs);
        dp[0] = jobs[0].profit;

        List<List<Job>> dp= new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            dp.add(new ArrayList<>());
        }

        int [] dp = new int[jobs.length];

        for (int i = 1; i < jobs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[j].finishTime < jobs[i].startTime && findSum(dp.get(j)) > findSum(dp.get(i))) {
                    dp.set(i) = dp.get(j); 
                }
            }

            dp.get(i).add(jobs[i]);
        }

        List<Job> maxChain = dp.get(0);
        int maxIdx = -1;
        for (int i = 0; i < jobs.length; i++) {
            if (findSum(maxChain) < findSum(dp.get(i))) {
                maxChain = dp.get(i);
            }
        }

        printJobs(maxChain);
    }

    int findSum(List<Job> jobs) {
        int profit = 0;
        for (Job j : jobs) {
            profit += j.profit;
        }

        return profilt;
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
