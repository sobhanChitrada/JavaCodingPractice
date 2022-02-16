package gs.codepad;

public class Count_ways_reach_nth_stair_steps_1_2_3 {
    public static void main(String[] args)
    {
        int n = 4;

        System.out.println(countWays(n));
    }

    private static int countWays(int n) {
        int a=1,b=2, c=4, d=0;
        if(n==0 || n==1 || n==2){
            return n;
        }
        if(n==3){
            return c;
        }
        for (int i=4; i<=n;i++){
            d=a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return d;
    }
}
