package gs.codepad;

import java.util.HashMap;
import java.util.LinkedHashMap;

class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    int c=0,cap=0;
    public LRUCache(int capacity) {
        map =new LinkedHashMap<>();
        cap=capacity;
    }
    
    public int get(int key) {
        int val=map.getOrDefault(key,-1);
        if(val!=-1)  {
            map.remove(key);
            map.put(key,val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) && c<=cap) {
            map.remove(key);
            map.put(key,value);
        }  else if(c<cap)  {
            c++;
            map.put(key,value);
         }  else {
            int temp=0;
            for(Integer k:map.keySet()) {
                   temp=k;
                   break;
            }
            map.remove(temp);
            map.put(key,value);
            
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */