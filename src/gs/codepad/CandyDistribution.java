package gs.codepad;

import java.util.Arrays;
//https://www.youtube.com/watch?v=h6_lIwZYHQw
public class CandyDistribution {
    public static void main(String[] args) {
        int []ratings = {12,4,3,11,34,34,1,67};
        int []ratings__ = {1,0,2}; //5
        int []ratings_ = {1,2,2}; //4
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {

        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        //
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && ans[i] <= ans[i + 1]) {
                ans[i] = ans[i + 1] + 1;
            }
        }

        int sm = 0;

        for (int a: ans) {
            sm += a;
        }

        return sm;
    }
}
