package gs.codepad;

import java.util.Arrays;

public class RevereseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        recurrsiveReverse(arr, 0, 5);
        for (int i=0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    private static int[] revereseArray(int[] array, int start, int end){

        while (start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
    private static int[] recurrsiveReverse(int[] array, int start, int end){
        if(start >= end) return array;
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        start++;
        end--;
        return recurrsiveReverse(array, start, end);
    }
}
