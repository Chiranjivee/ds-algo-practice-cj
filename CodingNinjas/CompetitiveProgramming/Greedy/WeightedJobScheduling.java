import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class WeightedJobScheduling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		List<Job> jobs = new ArrayList<>();
		while (n-- > 0)
			jobs.add(new Job(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		Collections.sort(jobs, (j1, j2) -> j1.end - j2.end);

		dp[0] = 0;
		for (int i = 1; i < dp.length; i++)
			dp[i] = Math.max(dp[i - 1], jobs.get(i - 1).profit + getLastNonConflictingJob(jobs, i - 1, dp));

		System.out.println(dp[dp.length - 1]);
	}

	public static int getLastNonConflictingJob(List<Job> jobs, int jobIdx, int[] dp) {
		// find a job whose start time is not between current's start and end
		int start = 0;
		int end = jobIdx - 1;
		int result = -1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (jobs.get(mid).end <= jobs.get(jobIdx).start) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return result == -1 ? 0 : dp[result + 1];
	}

}

class Job {
	int start;
	int end;
	int profit;

	Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}
