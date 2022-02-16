package gs.codepad;

import java.util.HashMap;

//https://www.youtube.com/watch?v=AmlVSNBHzJg
public class TotalNumberOfSubarrayWhoseSumIsEqualToK {
    public static void main(String[] args) {
        int arr[] = {1,1,1};
        int k =2;
        System.out.println(subArraySum(arr, k));
    }

    private static int subArraySum(int arr[], int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cur_sum = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            cur_sum += arr[i];
            //result is how many times map contains the difference between cur_sum -sum
            if(map.containsKey(cur_sum - sum)){
                result += map.get(cur_sum-sum);
            }
            map.put(cur_sum, map.getOrDefault(cur_sum, 0)+1);
        }
        return result;
    }
}
