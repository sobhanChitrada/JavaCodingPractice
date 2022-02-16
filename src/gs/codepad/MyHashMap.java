package gs.codepad;

import java.util.Arrays;
//https://leetcode.com/problems/design-hashmap/submissions/
class MyHashMap {
    int[] map;
    public MyHashMap() {
        map= new int[10000000];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
        map[key]=value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key]=-1;
    }
}
