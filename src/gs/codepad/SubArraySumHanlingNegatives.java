package gs.codepad;// Java program to print subarray with sum as given sum
import java.util.*;

class SubArraySumHanlingNegatives {


    private static void subArraySum(int[] arr, int n, int sum){
        int curr_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            curr_sum = curr_sum + arr[i];

            if(curr_sum - sum ==0){
                start = 0;
                end = i;
                break;
            }

            if(map.containsKey(curr_sum - sum)){
                start = map.get(curr_sum -sum) +1;
                end = i;
                break;
            }
            map.put(curr_sum, i);
        }
        if(end == -1){
            System.out.println("not possible");
        }else {
            System.out.println("start  "+ start +"  end  "+end);
        }

    }

    public static void subArraySum_(int[] arr, int n, int sum) {
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
            hashMap.put(cur_sum, i);

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
        int[] arr = {1, 4, 20, 3, 10, 5};
        int n = arr.length;
        int sum = 33;
        subArraySum(arr, n, sum);

    }
}
