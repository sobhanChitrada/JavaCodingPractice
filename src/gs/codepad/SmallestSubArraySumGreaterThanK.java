package gs.codepad;

import javafx.util.Pair;

import java.util.*;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solution/
//https://www.youtube.com/watch?v=K0NgGYEAkA4&list=RDCMUCnxhETjJtTPs37hOZ7vQ88g&start_radio=1&rv=K0NgGYEAkA4&t=1186
class SmallestSubArraySumGreaterThanK {

    public static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int i = 0; i < P.length; ++i) {
            //Q is monoQ, the values should always get increased ..
            //so if the next element in array larger than the lastElement in the Q, the remove until then
            while (!monoq.isEmpty() && P[i] <= P[monoq.getLast()])
                monoq.removeLast();
            //if the cur_sum (current element in the array) is reached more than the sum the remove the first element
            while (!monoq.isEmpty() && P[i] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, i - monoq.removeFirst());

            monoq.addLast(i);
        }

        return ans < N+1 ? ans : -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 2};
        int sum = 3;  //3

       /* int[] arr = {2, 7, 3, -8, 4, 10};
        int sum = 12;*/

        /*int[] arr = {1, 10, 5, 2, 7};
        int sum = 9; *///output  = 1

        /*int arr[] = {1, 4, 45, 6, 0, 19};
        int sum  =  51;*/ //Output: 3

        /*int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int sum = 280; *///Output: 4

        /*int arr[] = {1, 2, 4}; //not possible
        int sum = 8;  */  //not possible

        System.out.println(shortestSubarray(arr, sum));
    }
}
