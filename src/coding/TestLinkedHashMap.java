package coding;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> l= new LinkedHashMap();
        l.put(1, "one");
        l.put(2, "two");
        l.put(3, "three");
        l.put(4, "four");
        System.out.println("LinkedHashMap");
        for(int i:l.keySet()){
            System.out.println(i);
        }


        HashMap<Integer, String> h= new HashMap();
        h.put(1, "one");
        h.put(2, "two");
        h.put(3, "three");
        h.put(4, "four");
        System.out.println("HashMap");
        for(int i:h.keySet()){
            System.out.println(i);
        }

    }
}
