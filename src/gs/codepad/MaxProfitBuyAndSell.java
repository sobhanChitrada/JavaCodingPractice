package gs.codepad;

import java.io.*;

class MaxProfitBuyAndSell
{
    static int maxProfit(int price[], int size){
       int max_profit = 0;
       for(int i = 1; i<size; i++){
           if(price[i] > price[i-1]){
               max_profit += price[i] - price[i-1];
           }
       }
       return max_profit;
    }
    static int maxProfit_(int prices[], int size)
    {
        // maxProfit adds up the difference between
        // adjacent elements if they are in increasing order
        int maxProfit = 0;
        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }

    // Driver code
    public static void main(String[] args)
    {
        // stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;
        // function call
        System.out.println(maxProfit(price, n));
    }
}