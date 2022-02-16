package gs.codepad;// Java program for finding max path in matrix

import static java.lang.Math.max;

class MaximumSumPathMbyNMatrixFromTopToBottom_GFG
{
    public static int N = 3, M = 3;
    // Function to calculate max path in matrix
    static int findMaxPath(int mat[][]) {
        // To find max val in first row
        int res = -1;
        for (int i = 0; i < M; i++)
            res = max(res, mat[0][i]);

        for (int i = 1; i < N; i++)
        {
            res = -1;
            for (int j = 0; j < M; j++)
            {
                //i is row , j is column
                //if j = 0 means => there are no left column so there is no posibility to do j-1 i.e. noLeft corner
                //if j = M-1 mean => there are no no right side columns i.e we can not do j+1 so noRight corner
                // if j > 0 and j < M-1 means we have the option to move left and right sides , all posible moves
                if (j > 0 && j < M - 1) { // When all paths are possible
                    /*{1, 2, 3},
                    {9, 8, 7},
                    {4, 5, 6}}*/
                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j - 1]  "+ mat[i - 1][j - 1]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j + 1]   "+ mat[i - 1][j + 1]);

                    mat[i][j] += max(mat[i - 1][j], max(mat[i - 1][j - 1],  mat[i - 1][j + 1]));
                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);


                } else if (j > 0) { // When diagonal right is not possible

                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j]  "+ mat[i - 1][j]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j - 1]  "+ mat[i - 1][j - 1]);

                    mat[i][j] += max(mat[i - 1][j], mat[i - 1][j - 1]);

                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);
                } else if (j < M - 1) { // When diagonal left is not possible


                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j]  "+ mat[i - 1][j]);
                    System.out.println("when  " + i +"  " + j+ "    mat[i - 1][j + 1]   "+ mat[i - 1][j + 1]);


                    mat[i][j] += max(mat[i - 1][j], mat[i - 1][j + 1]);

                    System.out.println("when  " + i +"  " + j+ "    mat[i][j]   "+ mat[i][j]);
                }
                // Store max path sum
                res = max(mat[i][j], res);
            }
        }
        return res;
    }
    // driver program
    public static void main (String[] args)
    {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1,   0, 0, 30, 2, 5 },
                { 0,  10, 4, 0, 2, 0 },
                { 1,   0, 2, 20, 0, 4 }
        };

        int mat_[][] = {{1, 2, 3},
                {9, 8, 7},
                {4, 5, 6}};

        System.out.println(findMaximumPath(mat_));
    }

    private static int findMaximumPath(int[][] mat) {
        int resp = -1;
        for(int i = 1; i < N; i++){
            for(int j =0; j <M; j++){
                if(j>0 && j < M-1){
                    mat[i][j] += max(mat[i-1][j], max(mat[i-1][j-1], mat[i-1][j+1]));
                }else if(j > 0){
                    mat[i][j] += max(mat[i-1][j], mat[i-1][j-1]);
                }else if(j<M-1){
                    mat[i][j] += max(mat[i-1][j], mat[i-1][j+1]);
                }
                resp = max(resp, mat[i][j]);
            }
        }
        return resp;
    }
}