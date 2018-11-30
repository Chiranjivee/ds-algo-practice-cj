import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    public static final long serialVersionUID = 1L;
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int size) {
        this.capacity = size;
        this.cache = new LinkedHashMap<>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
                return this.size() > size;
            }
        };
    }

    public boolean containsKey(int key) {
        return cache.containsKey(key);
    }

    public void insert(int key, int value) {
        // only add non existing values.
        if (!containsKey(key)) {
            cache.put(key, value);
        }
    }

    public Integer read(int key) {
        if (containsKey(key)) {
            return cache.get(key);
        }
        return null;
    }

    public void showCache() {
        System.out.println("Status: " + cache.keySet().toString());
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.println("Entry: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.insert(1, 1);
        cache.insert(2, 2);

        cache.showCache();
        System.out.println("Cache read 1: " + cache.read(1));
        cache.showCache();
        System.out.println("Cache read 2: " + cache.read(2));
        cache.showCache();
    }
}