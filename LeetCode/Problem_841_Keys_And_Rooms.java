class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> keys = rooms.get(0);
        
        for (int i = 0; i < keys.size(); i++) {
            stack.push(keys.get(i));
        }
        
        visited[0] = true;
        while (!stack.isEmpty()) {
            // get the key
            Integer key = stack.pop();
            visited[key] = true;
            List<Integer> moreKeys = rooms.get(key);
            for (Integer tempKey : moreKeys) {
                if (!visited[tempKey]) stack.push(tempKey);
            }
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}