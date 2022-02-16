package gs.codepad;// Java program to print subarray with sum as given sum
import java.util.*;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
class SubArraySumHandlingNegatives {

    /*
        Calculate the current_sum, if currentSum - sum is 0 then starting to ending indexes are the subArray
        Create a map which has the current_sum and the latest index
        itrerate the array
        add the current element to the current_sum
        if the current sum - sum = 0 then its base case ...starting 0 and ending i
        else: if the map contains the difference between current_sum - sum ..means we have
        exceeded the sum...means if the exlude the current which mathes the key in the map..
        then our starting index starts from matched key x1
     */

    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cumulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            if(!hashMap.containsKey(cur_sum)) {
                hashMap.put(cur_sum, i);
            }

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }
    }

    // Driver code
    public static void main(String[] args) {
        //int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        //int sum = 23;


        /*int[] arr = {10, 2, -2, -20, 10};
        int n = arr.length;
        int sum = -10;*/

        /*int[] arr = {4, 2, -2, 1};
        int n = arr.length;
        int sum = 1;*/

        int[] arr = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n = arr.length;
        int sum = 280;

       /* int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int n = arr.length;*/

        /*int[] arr = {4, 2, -2, 1};
        int n = arr.length;
        int sum = 1;*/

        /*int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;
        int n = arr.length;*/

       /* int arr[] = {-10, 0, 2, -2, -20, 10};
        int sum = 20;
        int n = arr.length;*/
        subArraySum(arr, n, sum);
    }
}
