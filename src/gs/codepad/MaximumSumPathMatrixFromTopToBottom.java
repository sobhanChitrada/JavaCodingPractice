package gs.codepad;

public class MaximumSumPathMatrixFromTopToBottom {

    static int maxSum(int[][] mat, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                if(j == 0) {
                    //if the first row take i+1, j+1 (increment both column and row)
                    mat[i][j] += mat[i+1][j+1];
                } else if(j == n-1) {
                    //if the last row take i+1, j+1 (increment column and decrement row bcz it was already last so there
                    // no row to increment)
                    mat[i][j] += mat[i+1][j-1];
                } else {
                    //if middles rows... compare take max of next or previous rows
                    mat[i][j] += Math.max(mat[i+1][j+1], mat[i+1][j-1]);
                }
            }
        }
        for (int i =0; i< n; i++) {
            max = Math.max(max, mat[0][i]);
        }
        return max;
    }

    static int maxSum_(int[][] mat, int n){
        int max = Integer.MIN_VALUE;
        for (int i = n-2; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if(j == 0){
                    mat[i][j] += mat[i+1][j+1];
                }else if(j == n-1){
                    mat[i][j] += mat[i+1][j-1];
                }else {
                    mat[i][j] += Math.max(mat[i+1][j+1], mat[i+1][j-1]);
                }
            }
        }
        for(int i =0; i< n; i++){
            max = Math.max(max, mat[0][i]);
        }
        return max;
    }
    // Driver code
    public static void main (String[] args) {

        int mat[][] =  {{0, 100, 0, 0},
        {100, 0, 0, 0},
        {100, 0, 0, 0},
        {100, 0, 0, 0}};


        //28
        int mat_[][] = { { 5, 6, 1, 7 },
                { -2, 10, 8, -1 },
                { 3, -7, -9, 11 },
                { 12, -4, 2, 6 } };

        int n = 4;

        System.out.println("Maximum Sum = " + findMaxSumPath(mat_ , n));

    }
    private static int findMaxSumPath(int mat[][], int n) {
        int resp = -1;
        for (int i = 1; i < n; i++){
            for (int j=0; j<n; j++){
                if(j > 0 && j < n-1){
                    mat[i][j] += Math.max(mat[i-1][j-1], mat[i-1][j+1]);
                }else if(j>0) {
                    mat[i][j] += mat[i-1][j-1];
                } else if(j<n-1) {
                    mat[i][j] += mat[i-1][j+1];
                }
                resp = Math.max(resp, mat[i][j]);
            }
        }
        return resp;
    }
}
