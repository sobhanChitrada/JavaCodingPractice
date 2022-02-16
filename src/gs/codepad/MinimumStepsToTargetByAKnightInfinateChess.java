package gs.codepad;

import java.util.*;

//https://www.youtube.com/watch?v=UqFXSGeFHTI&t=534s
public class MinimumStepsToTargetByAKnightInfinateChess {

    public static void main(String[] args) {
        System.out.println(minSteps(2,1));
    }

    private static int minSteps(int x, int y) {
        int dx[] = {-1, -2, 1, 2, -1, -2, 1, 2};
        int dy[] = {-2, -1, -2, -1, 2, 1, 2, 1};

        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(0, 0));
        Set<String> visits = new HashSet<>();
        visits.add("0,0");
        int moves = 0;
        Coordinates c;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                c = q.remove();
                if(c.x == x && c.y == y){
                    return moves;
                }
                for (int j =0; j< dx.length; j++){
                    int newX = c.x + dx[j];
                    int newY = c.y + dy[j];
                    String s = newX +","+ newY;
                    if(!visits.contains(s) && newX >= -2 && newY >= -2){
                        q.add(new Coordinates(newX, newY));
                        visits.add(s);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
class Coordinates {
    int x;
    int y;
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
}