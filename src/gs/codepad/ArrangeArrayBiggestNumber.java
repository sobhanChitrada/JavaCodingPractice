package gs.codepad;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

//https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class ArrangeArrayBiggestNumber {
    public static void main(String[] args) {
        Vector<String> arr;
        arr = new Vector<>();
       /* arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        arr.add("12");
        arr.add("121");*/
        // output should be 6054854654


        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");

       /* Input :  [1, 34, 3, 98, 9, 76, 45, 4, 12, 121]
        Output : 99876454343121211

        Input :  [12, 121]
        Output : 12121*/

        arrangeLargestNumber(arr);
    }

    private static void arrangeLargestNumber(Vector<String> arr) {
        MyCompararot mc = new MyCompararot();
        Collections.sort(arr, mc);
        Iterator it = arr.iterator();
        String result = "";
        while(it.hasNext()) {
            result += it.next();
        }
        System.out.println(result);
    }
}

class MyCompararot implements Comparator<String> {
    @Override
    public int compare(String x, String y){
        String xy = x+y;
        String yx = y+x;
        return xy.compareTo(yx) > 0 ? -1:1;
    }
}
