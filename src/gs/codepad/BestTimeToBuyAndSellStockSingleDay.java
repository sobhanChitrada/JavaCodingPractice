package gs.codepad;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStockSingleDay {
    public static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        //{7,1,5,3,6,4}

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        int[] prices_ = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
       // System.out.println(maxProfit(prices_));
        int min_price=Integer.MAX_VALUE;
        int profit=0;
        int max_profit=Integer.MIN_VALUE;
        for(int i=0; i<prices_.length;i++){
            if(prices_[i]<min_price){
                min_price=prices_[i];
            }
            profit=prices_[i]-min_price;
            if(max_profit<profit){
                max_profit=profit;
            }
        }
        System.out.println(max_profit);
    }

}
