package gs.codepad;

import java.util.ArrayList;

class StockBuySell {

  // This function finds the buy sell schedule for maximum profit
  void stockBuySell(int price[], int n)
  {
    // Prices must be given for at least two days
    if (n == 1)
      return;

    int count = 0;

    // solution array
    ArrayList<Interval_> sol = new ArrayList<>();

    // Traverse through given price array
    int i = 0;
    while (i < n - 1) {
      // Find Local Minima. Note that the limit is (n-2) as we are
      // comparing present element to the next element.
      while ((i < n - 1) && (price[i + 1] <= price[i]))
        i++;

      // If we reached the end, break as no further solution possible
      if (i == n - 1)
        break;

      Interval_ e = new Interval_();
      e.buy = i++;
      // Store the index of minima

      // Find Local Maxima.  Note that the limit is (n-1) as we are
      // comparing to previous element
      while ((i < n) && (price[i] >= price[i - 1]))
        i++;

      // Store the index of maxima
      e.sell = i - 1;
      sol.add(e);

      // Increment number of buy/sell
      count++;
    }

    // print solution
    if (count == 0)
      System.out.println("There is no day when buying the stock "
              + "will make profit");
    else
      for (int j = 0; j < count; j++)
        System.out.println("Buy on day: " + sol.get(j).buy
                + "        "
                + "Sell on day : " + sol.get(j).sell);

    return;
  }

  public static void main(String args[])
  {
    StockBuySell stock = new StockBuySell();

    // stock prices on consecutive days
    int price[] = { 100, 180, 260, 310, 40, 535, 695 };
    int n = price.length;

    // function call
    stock.stockBuySell(price, n);
  }
  private static void buyAndSell(int price[], int n){
    if(n == 1){
      return;
    }
    int i = 0, count =0;
    ArrayList<Interval_> al = new ArrayList<>();
    while (i < n){
     while (i < n-1 && (price[i+1] <= price[i])){
       i++;
     }
     if(i == n){
       break;
     }
     Interval_ in = new Interval_();
     in.buy = i++;

     while (i < n && (price[i] >= price[i-1])){
       i++;
     }
     in.sell = i-1;
     al.add(in);
     count++;
    }
    // print solution
    if (count == 0)
      System.out.println("There is no day when buying the stock "
              + "will make profit");
    else
      for (int j = 0; j < count; j++)
        System.out.println("Buy on day: " + al.get(j).buy
                + "        "
                + "Sell on day : " + al.get(j).sell);

    return;
  }

}
// Solution structure
class Interval_ {
  int buy, sell;
}

