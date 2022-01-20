package gs.codepad;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class ArrangeArrayBiggestNumber {
    public static void main(String[] args) {
        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        arrangeLargestNumber(arr);
    }

    private static void arrangeLargestNumber(Vector<String> arr){
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x+y;
                String yx = y+x;

                return xy.compareTo(yx) > 0 ? -1:1;
            }
        });
        Iterator it = arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }
}
