import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private HashMap<Integer, ListNode> cacheMap = new HashMap<>();
    private LinkedList<ListNode> myList = new LinkedList<>();
    private int maxCacheSize;

    public void insertKeyValue(int key, int value) {
        ListNode node = new ListNode(key, value);

        if (cacheMap.containsKey(key)) {
            myList.remove(node);
        }

        if (cacheMap.size() >= maxCacheSize) {
            deleteKey(myList.getLast().key);
        }
        
        myList.addFirst(node);
        cacheMap.put(key, node);
    }

    public Integer getValueByKey(int key) {
        if (cacheMap.get(key) == null) {
            return null;
        }

        ListNode resultNode = cacheMap.get(key);

        if (myList.getFirst().key != resultNode.key) {
            myList.remove(resultNode);
            myList.addFirst(resultNode);
        }

        return resultNode.value;
    }

    public void deleteKey(int key) {
        ListNode keyNode = cacheMap.get(key);
        if (keyNode == null) {
            return;
        }

        myList.remove(keyNode);
        cacheMap.remove(key);
    }

    public LRUCache(int size) {
        this.maxCacheSize = size;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValue(1, 87);
        cache.insertKeyValue(2, 23);
        cache.insertKeyValue(3, 234);
        cache.insertKeyValue(4, 387);

        System.out.println("Get key 1: " + cache.getValueByKey(1));
        System.out.println("Get key 4: " + cache.getValueByKey(4));

        cache.insertKeyValue(5, 87);

        System.out.println("Get key 2: " + cache.getValueByKey(2));
    }
}

class ListNode {
    int key;
    int value;
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        ListNode temp = (ListNode) o;
        if (temp.key == this.key && temp.value == this.value) {
            return true;
        }

        return false;
    }
}