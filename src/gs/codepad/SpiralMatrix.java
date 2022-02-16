package gs.codepad;

import java.util.List;
import java.util.Vector;

public class SpiralMatrix {

    private static Vector<Integer> spiralOrder(int[][] matrix) {
        int T,B,L,R,dir;
        T=0;
        B=matrix.length-1;
        L=0;
        R=matrix[0].length-1;
        dir=0;
        int i;
        Vector<Integer> ans = new Vector<>();

        while(T<=B && L<=R)
        {
            if(dir==0)
            {
                for(i=L;i<=R;i++)
                    ans.add(matrix[T][i]);
                T++;
            }
            else if(dir==1)
            {
                for(i=T;i<=B;i++)
                    ans.add(matrix[i][R]);
                R--;
            }
            else if(dir==2)
            {
                for(i=R;i>=L;i--)
                    ans.add(matrix[B][i]);
                B--;
            }
            else if(dir==3)
            {
                for(i=B;i>=T;i--)
                    ans.add(matrix[i][L]);
                L++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
    private static Vector<Integer> spiralOrder_(int[][] matrix) {
        int top =0, bottom=matrix.length-1;
        int left=0, right=matrix[0].length-1;
        int direction =0;
        Vector<Integer> out= new Vector<>();
        while(top<=bottom && left<=right){

            if(direction==0){
                for(int i=left; i<=right; i++){
                    out.add(matrix[top][i]);
                }
                top ++;
            }
            if(direction==1){
                for (int i=top; i<=bottom; i++){
                    out.add(matrix[i][right]);
                }
                right --;
            }else  if(direction==2){
                for (int i=right; i>=left; i--){
                    out.add(matrix[bottom][i]);
                }
                bottom --;
            }else if(direction==3){
                for (int i=bottom; i>=top; i--){
                    out.add(matrix[i][left]);
                }
                left ++;
            }
            direction = (direction+1)%4;
        }
        return out;
    }
    public static void main(String[] args) {
        int[][] matrix =   {{1,2,3},
                            {4,5,6},
                            {7,8,9}};
       /* int[][] matrix =   {{1,2,3,4,5},
                            {4,5,6,7,8},
                            {7,8,9,10,11},
                             {7,8,9,10,11}};*/
        System.out.println(spiralOrder_(matrix));
    }


}
