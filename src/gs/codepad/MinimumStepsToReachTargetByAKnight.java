package gs.codepad;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;

// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight
class MinimumStepsToReachTargetByAKnight {
    //https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/?ref=rp

    // Class for storing a cell's data
    static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    // Method returns minimum step
    // to reach target position
    static int minStepToReachTarget(int knightPos[], int targetPos[], int N)
    {
        // x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        // queue for storing states of knight in board
        Vector<cell> q = new Vector<>();
        // push starting position of knight with 0 distance
        q.add(new cell(knightPos[0], knightPos[1], 0));

        boolean visit[][] = new boolean[N + 1][N + 1];
        // make all cell unvisited
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;
        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;
        cell t;
        int x, y;
        // loop until we have one element in queue
        while (!q.isEmpty()) {
            t = q.firstElement();
            q.remove(0);

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If reachable state is not yet visited and inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 6;
        int knightPos[] = { 2, 4 };
        int targetPos[] = { 6, 4};
        System.out.println(minStep_(knightPos, targetPos, N));
    }

    private static int minStep_(int[] knightPos, int[] targetPos, int n) {

        int dx[] = {-1, -2, 1, 2, -1, -2, 1, 2};
        int dy[] = {-2, -1, -2, -1, 2, 1, 2, 1};

        Vector<cell> q= new Vector<>();
        q.add(new cell(knightPos[0], knightPos[1], 0));

        boolean visits[][] = new boolean[n+1][n+1];
        for (int i=1; i <= n; i++){
            for (int j=1; j<=n; j++){
                visits[i][j] = false;
            }
        }
        visits[knightPos[0]] [knightPos[1]] = true;
        cell t;
        while (!q.isEmpty()){
            t = q.firstElement();
            q.remove(0);
            if(t.x == targetPos[0] && t.y == targetPos[1]){
                return t.dis;
            }
            for (int i = 0; i < 8; i++){
                int newX = t.x + dx[i];
                int newY = t.y + dy[i];
                if(isInside(newX, newY, n) && !visits[newX][newY]){
                    visits[newX][newY] = true;
                    q.add(new cell(newX, newY, t.dis+1));
                }
            }
        }

        return 1;
    }
    private static boolean isInside_(int x, int y, int n){
        if(1<= x && x <= n && 1<=y && y <=n){
            return true;
        }
        return false;
    }

}