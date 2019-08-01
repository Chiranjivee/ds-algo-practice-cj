class Solution {
    static int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    static int limit = (int)1e6;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for(int block[] : blocked)
            blocks.add(block[0] + ":" + block[1]);
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }
    public boolean bfs(int[] source, int[] target, Set<String> blocks){
        Set<String> seen = new HashSet<>();
        seen.add(source[0] + ":" + source[1]);
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(source);
        
        while(!bfs.isEmpty()){
            int cur[] = bfs.poll();
            for(int dir[] : dirs){
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if(nextX < 0 || nextY < 0 || nextX >= limit || nextY >= limit) continue;
                String key = nextX + ":" + nextY;
                if(seen.contains(key) || blocks.contains(key)) continue;
                if(nextX == target[0] && nextY == target[1]) return true;
                bfs.offer(new int[]{nextX, nextY});
                seen.add(key);
            }
            if(seen.size() == 20000) return true;
        }
        return false;
    }
}
