class Solution {
    public String minimizeError(String[] prices, int target) {
	 	DecimalFormat df = new DecimalFormat("#.000");
	 	HashMap<Integer, Double>[] memo = new HashMap[prices.length + 1];
	 	double ans = minimizeError(memo, 0, target, prices);
	 	if(ans == 0)
            return "0.000";
        return ans <= 1000000 ? df.format(ans) : "-1";
    }
	
    public double minimizeError(HashMap<Integer, Double>[] memo, int index, int target, String[] prices){
    	if(target < 0) {
        	return 2000000;
        }
    	if(memo[index] != null && memo[index].get(target) != null) {
        	return memo[index].get(target);
        }
    	if(index == prices.length){
    		if(target == 0) {
    			return 0;
    		}
            return 2000000;
        }
        double current = Double.parseDouble(prices[index]);
        int floor =  (int) Math.floor(current);
        int ceil = (int) Math.ceil(current);
        double currError = Math.min(current - floor + minimizeError(memo, index + 1, target - floor, prices),
        		                    ceil - current + minimizeError(memo, index + 1, target - ceil, prices));
        if(memo[index] == null) {
        	memo[index] = new HashMap<Integer, Double>();
        }
        memo[index].put(target, currError);
        return currError;
    }
}
