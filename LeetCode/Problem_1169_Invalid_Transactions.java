class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList();
        int n = transactions.length;
        if (n == 0) return ans;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] money = new int[n];
        String[] city = new String[n];
        boolean[] add = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] items = transactions[i].split(",");
            name[i] = items[0];
            time[i] = Integer.parseInt(items[1]);
            money[i] = Integer.parseInt(items[2]);
            city[i] = items[3];
        }
        
        for (int i = 0; i < n; i++) {
            if (money[i] > 1000)
                add[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                    add[i] = true;
                    add[j] = true;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if (add[i])
                ans.add(transactions[i]);
        }
        return ans;
    }
}
