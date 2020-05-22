class LRUCache {
    int maxCapacity = 0;
    Map<Integer, ListNode> cacheMap = new HashMap<>();
    LinkedList<ListNode> cacheList = new LinkedList<>();
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }
    
    public int get(int key) {
        
        ListNode item = cacheMap.get(key);
        if (item == null) {
            return -1;
        }

        cacheList.remove(item);
        cacheList.addFirst(item);
        return item.value;
    }
    
    public void put(int key, int value) {
        
        ListNode item = cacheMap.get(key);
        if (item == null) {
            if (cacheMap.size() == maxCapacity) {
                ListNode lruItem = cacheList.removeLast();
                cacheMap.remove(lruItem.key);
            }
            
            ListNode newItem = new ListNode(key, value);
            cacheMap.put(key, newItem);
            cacheList.addFirst(newItem);
        } else { // update
            cacheList.removeItem(item);
            cacheMap.remove(item.key);
            ListNode newItem = new ListNode(key, value);
            cacheMap.put(key, newItem);
            cacheList.addFirst(newItem);
        }
    }
}

class ListNode {
    int key;
    int value;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
