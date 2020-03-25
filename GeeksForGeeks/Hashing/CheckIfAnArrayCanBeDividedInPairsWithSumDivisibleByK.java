class Solution {
    public boolean canFormPair(int [] arr, int k) {
        if (arr.length % 2 != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (map.containsKey(rem)) {
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (2 * rem == k) {
                if (map.get(rem) % 2 == 1) {
                    return false;
                }
            } else if (rem == 0) {
                if (map.get(rem) % 2 == 1) {
                    return false;
                }
            } else {
                if (map.get(rem) != map.get(k - rem)) {
                    return false;
                }
            }
        }

        return true;
    }
}
