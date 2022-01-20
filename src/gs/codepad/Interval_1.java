package gs.codepad;

import java.util.List;
import java.util.ArrayList;

class Interval_1 {
    public int startTime;
    public int endTime;
    public int price;

    public Interval_1(int startTime, int endTime, int price){
    this.startTime = startTime;
    this.endTime = endTime;
    this.price = price;
  }
}

class Solution{
  
  private static List<Interval_1> minimumPriceIntervals(List<Interval_1> inputList){
  int max_time = 0, min_time = 25;
  for(Interval_1 list : inputList){
    if(list.endTime > max_time)
      max_time = list.endTime;
    if(list.startTime < min_time)
      min_time = list.startTime;
  }
  
  // Creating a new array and intializing each elements with highest integer value
  int[] arr = new int[max_time - min_time];
  for(int i = 0; i < arr.length; i++)
    arr[i] = Integer.MAX_VALUE;
    
  // Filling the array with the price
  for(Interval_1 list : inputList){
    int c = list.endTime - list.startTime;
    int i = list.startTime - 1;
    while(c > 0){
      if(list.price < arr[i])
        arr[i] = list.price;
      i++;
      c--;
    }
  }
  
  List<Interval_1> outputList = new ArrayList<Interval_1>();
  int start_time = 0;
  int end_time = 1;
  int item_price = 0;
  while(end_time < arr.length) {
    int start = end_time;
    while(end_time < arr.length && arr[start_time] == arr[end_time]){
      item_price = arr[start_time];
      start_time = start_time + 1;
      end_time = end_time + 1;
    }
    if(end_time == arr.length){
      outputList.add(new Interval_1(start, end_time+1, item_price));
      return outputList;
    } else if(arr[start_time] != arr[end_time]){
      outputList.add(new Interval_1(start, end_time+1, item_price));
      item_price = arr[end_time];
      start_time = end_time;
      end_time = end_time + 1;
    }
  }
  return outputList;
  }
    
  public static void main(String[] args) {
    List<Interval_1> inputList = new ArrayList<Interval_1>();
    inputList.add(new Interval_1(1, 5, 20));
    inputList.add(new Interval_1(3, 8, 15));
    inputList.add(new Interval_1(8, 10, 8));

    List<Interval_1> outputList = minimumPriceIntervals(inputList);
    for(Interval_1 list : outputList)
      System.out.println(list.startTime+" "+list.endTime+" "+list.price);
  }
}


