package gs.codepad;

public class PositionOfRobotAfterGivenMovements {
    public static void main(String[] args) {
        String move = "UDDLRL";
        finalPosition(move);
    }

    private static void finalPosition(String move) {
        int move_left =0, move_right =0, move_up = 0, move_down =0;

        for (int i = 0; i < move.length(); i++){
            if(move.charAt(i) == 'U') {
                move_up++;
            }
            if(move.charAt(i) == 'D') {
                move_down++;
            }
            if(move.charAt(i) == 'L') {
                move_left++;
            }
            if(move.charAt(i) == 'R') {
                move_right++;
            }
        }
        System.out.println(move_right - move_left);
        System.out.println(move_up - move_down);
    }
}
