class SummaryRanges {
    
    private TreeMap<Integer, Integer> tm;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tm = new TreeMap<>();
    }
    
    public void addNum(int val) {
        // get the floor key, left endpoint of the closest leftward interval of val
        Integer fk = tm.floorKey(val);
        // get corresponding floor value, right endpoint (use null if interval does not exist)
        Integer fv = fk == null ? null : tm.get(fk);
        // get the ceiling key, left endpoint of the closest rightward interval of val
        Integer ck = tm.ceilingKey(val);
        // get corresponding floor value, right endpoint (use null if interval does not exist)
        Integer cv = ck == null ? null : tm.get(ck);
        
        //if the value is already contained in an interval, skip it and return
        if(fk != null){
            if(val <=fv){
                return;
            }
        }
        
        //new key and new value, the new interval we will add
        Integer nk;
        Integer nv;
        
        //check if the value can be merged with the left interval
        //correct set the new key and new value of interval to be added later
        if(fk == null){
            nk = val;
        }else if(fv == val -1){
            nk = fk;
            //remove left interval
            tm.remove(fk);
        }else{
            nk = val;
        }
        
        //check if the value can be merged with the right interval
        //correct set the new key and new value of interval to be added later
        if(ck == null){
            nv = val;
        }else if(ck == val + 1){
            nv = cv;
            //remove right interval
            tm.remove(ck);
        }else{
            nv = val;
        }

        //add new interval which contains the val, and any merged interval on left or right
        tm.put(nk, nv);
        
    }
    
    public int[][] getIntervals() {
        int[][] intervals = new int[tm.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e: tm.entrySet()){
            intervals[i][0] = e.getKey().intValue();
            intervals[i][1] = e.getValue().intValue();
            i++;
        }
        return intervals;
    }
}
