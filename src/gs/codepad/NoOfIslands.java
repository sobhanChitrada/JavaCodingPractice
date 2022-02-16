package gs.codepad;

public class NoOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                    };

        char[][] grid_ = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid_));
    }
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if(rows == 0){
            return 0;
        }
        int noOfIsLand = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] =='1'){
                    markCurrent(grid, i, j, rows, columns);
                    noOfIsLand += 1;
                }
            }
        }

        return noOfIsLand;
    }
    public static void markCurrent(char[][] matrix, int x, int y, int r, int c){
        //1st four are boundries
        //last condition : if the current piece of land is visited or not
        //if is not visited or if it is water body then just return
        if(x<0 || x>=r || y <0 || y >= c || matrix[x][y] != '1') {
            return;
        }
        matrix[x][y] = 2;

        markCurrent(matrix, x+1, y, r, c);
        markCurrent(matrix, x, y+1, r, c);
        markCurrent(matrix, x-1, y, r, c);
        markCurrent(matrix, x, y-1, r, c);

    }
}
