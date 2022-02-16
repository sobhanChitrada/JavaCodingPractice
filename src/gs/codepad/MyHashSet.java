package gs.codepad;

import java.util.Arrays;

//https://leetcode.com/problems/design-hashset/discuss/1739863/Super-Simple-Java
class MyHashSet {
    int[] hash;

    public MyHashSet() {
        hash = new int[1000001];
        Arrays.fill(hash, -1);
        /*for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }*/
    }
    
    public void add(int key) {
        hash[key] = key;
    }
    
    public void remove(int key) {
        hash[key] = -1;
    }
    
    public boolean contains(int key) {
        return hash[key] != -1;
    }
}