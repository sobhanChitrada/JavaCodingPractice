package gs.codepad;

import java.util.HashSet;

public class FindElementsPresent1stAarrayNotInSecond {
    public static void main(String[] args) {
        int a[] = { 1, 2, 6, 3, 4, 5 };
        int b[] = { 2, 4, 3, 1, 0 };
        int n = a.length;
        int m = b.length;
        findMissing(a, b, n, m);
    }

    private static void findMissing(int[] a, int[] b, int n, int m) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < b.length; i++){
            set.add(b[i]);
        }
        for (int i = 0; i < a.length; i++){
            if(!set.contains(a[i])){
                System.out.println(a[i]);
            }
        }
    }
}
