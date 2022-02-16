package coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class LRUCacheHashMapImpl {

    private int capacity;
    private ArrayList<Integer> latestUsedCache = new ArrayList<Integer>();
    private Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    

    public LRUCacheHashMapImpl(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (m.containsKey(key)) {
            updateUsage(key);
            return m.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (m.size() >= capacity && !m.containsKey(key)) {
            removeLeastUsedCache(key);
        }
        m.put(key, value);
        updateUsage(key);
    }
    
    private void removeLeastUsedCache(int key) {
        m.remove(latestUsedCache.get(0));
        latestUsedCache.remove(0);
    }
    
    private void updateUsage(int key) {
        if (latestUsedCache.contains(key)) {
            int i = latestUsedCache.indexOf(key);
            latestUsedCache.remove(i);
        }
        latestUsedCache.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */