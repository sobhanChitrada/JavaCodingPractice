package gs.codepad;

public class RainwaterTrapping {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;
        maxWater(arr, n);
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
            }
            else {
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
    private static void maxWater(int arr[], int n){
        int max_left = 0, max_right = 0, result = 0, lo = 0, hi = n-1;
        while(lo <= hi){
            if(arr[lo] < arr[hi]){
                if(max_left < arr[lo]){
                    max_left = arr[lo];
                }else{
                    result += max_left - arr[lo];
                }
                lo++;
            }else{
                if(max_right < arr[hi]){
                    max_right= arr[hi];
                }else{
                    result += max_right - arr[hi];
                }
                hi--;
            }
        }
        System.out.println(result);
    }
}
