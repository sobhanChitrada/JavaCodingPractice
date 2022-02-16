package gs.codepad;

import java.util.Arrays;
 
class ProductExceptSelf
{
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] out = new int[n];
        if(n < 1){
            return null;
        }
        int product =1;
        for(int i=0; i<n; i++){
            product *= nums[i];
            out[i]=product;
        }
        product=1;
        for(int i=n-1; i>0; i--){
            out[i]=out[i-1]*product;
            product *= nums[i];
        }
        out[0]=product;
        return out;
    }
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5 };

        System.out.println(productExceptSelf(A));
       // findProduct(A, A.length, 1, 0);

        // print the modified array
       // System.out.println(Arrays.toString(A));
    }
}
