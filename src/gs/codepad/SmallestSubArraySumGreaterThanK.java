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

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
    private static int shortestSubArray(int arr[], int sum){
        int n = arr.length;
        int result = n +1;
        long p[] = new long[n+1];
        for (int i = 0; i < n; i++)
            p[i+1] = p[i] + (long)arr[i];

        Deque<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            while (!q.isEmpty() && p[i] <= p[q.getLast()]){
                q.removeLast();
            }
            while (!q.isEmpty() && p[i] >= p[q.getFirst()]+sum){
                result = Math.min(result, i - q.removeFirst());
            }
            q.addLast(i);
        }


        return result;
    }

    public static void main(String[] args) {
        /*int[] arr = {2, -1, 2};
        int sum = 3;*/

        int[] arr = {2, 7, 3, -8, 4, 10};
        int sum = 12;

        System.out.println(shortestSubarray(arr, sum));
    }
}
