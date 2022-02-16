package gs.codepad;

/*
Iterate the array from both sides,
if the left value is max in the array find the left then add (left_max - current array value ) to result
if the right side value then find the right_max value add (right_max - current index value in the array) to the result
 */
//https://leetcode.com/problems/trapping-rain-water/
public class RainwaterTrapping {
    public static void main(String[] args) {
        //int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int arr[] = { 0,1,0,2,1,0,1,3,2,1,2,1};
        int n = arr.length;
        findWater(arr, n);
    }
    static int findWater(int arr[], int n) {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else
                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            } else {
                if (arr[hi] > right_max)
                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }
        System.out.println(result);
        return result;
    }
}
//https://www.geeksforgeeks.org/trapping-rain-water/