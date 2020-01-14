class JobSequencingProblem {
    public void jobSequencing(Job [] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int deadline = 0;

        for (int i = 0; i < jobs.length; i++) {
            if (deadline < jobs[i].deadline) {
                System.out.println(jobs[i]);
                deadline++;
            }
        }
    }
}
