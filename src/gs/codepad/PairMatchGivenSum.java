package gs.codepad;/* Java implementation of simple method to find count of
pairs with given sum*/

import java.util.HashMap;

class PairMatchGivenSum {
    // Returns number of pairs in arr[0..n-1] with sum equal  to 'sum'
    static int getPairsCount(int arr[], int length, int sum) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (m.containsKey(sum - arr[i])) {
                count += m.get(sum - arr[i]);
            }
            if(m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i])+1);
            } else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }

    // Driver function to test the above function
    public static void main(String[] args)
    {
        int arr[] = new int[] { 1,1,1,1 };
        int n = arr.length;
        int sum = 2;
        System.out.print("Count of pairs is " + getPairsCount(arr, n, sum));
    }

}