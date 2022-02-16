package gs.codepad;/*package whatever //do not write package name here */

import java.io.*;
        import java.util.*;

class MaximumSumPathMbyNMatrixFromTopToBottom {
    static int i=0;
    static	int max_sum = 0;
    public static void main (String[] args) {

        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                        { 1, 0, 0, 30, 2, 5 },
                        { 0, 10, 4, 0, 2, 0 },
                        { 1, 0, 2, 20, 0, 4 }
                     };

        int arr[] = new int[6];
        for(int i=0;i<mat[0].length;i++)
            sum(mat, arr, i,0,0);
        System.out.println(max_sum);
    }

    public  static void sum(int[][]mat, int[] arr, int column, int row, int sum) {
        if(row < 0 || column < 0 || column > mat[0].length-1 ) {
            return;
        } else {
            sum += mat[row][column];
        }
        if(row == mat.length-1) {
            if(max_sum < sum){
                max_sum = sum;
            }
            arr[column]=sum;
            return;
        }
        //down
        sum(mat, arr, column,row+1, sum);
        //diagonally left down
        sum(mat,arr,column-1,row+1,sum);
        //diagonally right down  
        sum(mat,arr,column+1,row+1,sum);
    }
}
