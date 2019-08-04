/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
class SnapshotArray {

    Map<Integer,TreeMap<Integer,Integer>> snapMap = new HashMap<>();
    int snap_id = 0;
    Map<Integer,Integer> currMap = new HashMap<>();
    public SnapshotArray(int length) {}
    
    public void set(int index, int val) {
        currMap.put(index,val);
    }
    
    public int snap() {
        for(Map.Entry<Integer,Integer> entry: currMap.entrySet()){
            int index = entry.getKey();
            int val = entry.getValue();
            TreeMap<Integer,Integer> temp = snapMap.getOrDefault(index,new TreeMap<Integer,Integer>());
            Integer snapIndex = temp.floorKey(snap_id);
            if(snapIndex == null || temp.get(snapIndex) != val){
                temp.put(snap_id,val);
                snapMap.put(index,temp);
            }
        }
        snap_id++;
        return snap_id-1;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer,Integer> temp = snapMap.getOrDefault(index,new TreeMap<Integer,Integer>());
        Integer snapIndex = temp.floorKey(snap_id);
        if(snapIndex == null) return 0;
        else return temp.get(snapIndex);
    }
}
