package coding;

//Java O(n) solution for 
//finding smallest subarray 
//with sum greater than x 
import java.io.*;

class SmallestSubArray {

//Returns length of smallest 
//subarray with sum greater 
//than x. If there is no 
//subarray with given sum, 
//then returns n+1 
	static int smallestSubArraySum(int arr[], int x) {
		// Initialize current
		// sum and minimum length
		int n = arr.length;
		int current_sum = 0, minimum_length = n + 1;

		// Initialize starting
		// and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array
			// elements while current
			// sum is smaller than x
			while (current_sum <= x && end < n) {
				// Ignore subarrays with
				// negative sum if x is
				// positive.
				if (current_sum <= 0 && x > 0) {
					start = end;
					current_sum = 0;
				}

				current_sum += arr[end++];
			}

			// If current sum becomes
			// greater than x.
			while (current_sum > x && start < n) {
				// Update minimum
				// length if needed
				if (end - start < minimum_length)
					minimum_length = end - start;

				// remove starting elements
				current_sum -= arr[start++];
			}
		}
		if(minimum_length == n+1){
			return -1;
		}
		return minimum_length;
	}

//Driver Code 
	public static void main(String[] args) {
		int[] arr1 = {10, 2, -2, -20, 10};
		int n1 = arr1.length;
		int x = -10;

		/*int arr1[] = { -8, 1, 4, 2, -6 };

		int x = 12;*/

		int res1 = smallestSubArraySum(arr1,x);
		if (res1 == n1 + 1)
			System.out.println("Not possible");
		else
			System.out.println(res1);
	}
}
