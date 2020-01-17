class ConnectNRopesWithMinimumCost {
	static int minCost(int arr[], int n) {
		// Create a priority queue 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer> ();

		// Adding items to the pQueue 
		for (int i = 0; i<n; i++) {
			pq.add(arr[i]);
		}

		// Initialize result 
		int res = 0;

		// While size of priority queue 
		// is more than 1 
		while (pq.size() > 1) {
			// Extract shortest two ropes from pq 
			int first = pq.poll();
			int second = pq.poll();

			// Connect the ropes: update result 
			// and insert the new rope to pq 
			res += first + second;
			pq.add(first + second);
		}

		return res;
	}
}
