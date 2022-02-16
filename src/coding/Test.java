package coding;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<IntervalCoderPad> inputList = new ArrayList<IntervalCoderPad>();
        inputList.add(new IntervalCoderPad(1, 5, 20));
        inputList.add(new IntervalCoderPad(3, 8, 15));
        inputList.add(new IntervalCoderPad(7, 10, 8));
        /*1 3 20
            3 7 15
            7 10 8*/

        List<IntervalCoderPad> outputList = getIntervalList(inputList);
        for (IntervalCoderPad list : outputList)
            System.out.println(list.startTime + " " + list.endTime + " " + list.price);
    }

    private static List<IntervalCoderPad> getIntervalList(List<IntervalCoderPad> inputList) {
        //max and min interval in the list
        //create an array with size of max and min interval
        //array populate with max integers
        //populate with actul price
        //start_time to end_time prepare the actual list with minimum price
        //price list

        int max_time = 0, min_time = 25;

        for (IntervalCoderPad ic : inputList) {
            if (ic.startTime < min_time) {
                min_time = ic.startTime;
            }
            if (ic.endTime > max_time) {
                max_time = ic.endTime;
            }
        }
        int prices[] = new int[max_time - min_time];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.MAX_VALUE;
        }

        for (IntervalCoderPad ic : inputList) {
            int c = ic.endTime - ic.startTime;
            int i = ic.startTime - 1;
            while (c > 0) {
                if (ic.price < prices[i]) {
                    prices[i] = ic.price;
                }
                i++;
                c--;
            }
        }
        int start_time = 0, end_time = 1;
        ArrayList<IntervalCoderPad> output = new ArrayList();
        int pri = 0;
        while (end_time < prices.length) {
            int start = end_time;
            while (end_time < prices.length - 1 && prices[start_time] == prices[end_time]) {
                pri = prices[start_time];
                start_time = start_time + 1;
                end_time = end_time + 1;
            }
            if (end_time == prices.length - 1) {
                output.add(new IntervalCoderPad(start, end_time + 1, pri));
                return output;
            } else if (prices[start_time] != prices[end_time]) {
                output.add(new IntervalCoderPad(start, end_time + 1, pri));
                start_time = start_time + 1;
                pri = prices[end_time];
                end_time = end_time + 1;
            }
        }
        return output;
    }
}
class IntervalCoderPad {
    public int startTime;
    public int endTime;
    public int price;

    public IntervalCoderPad(int startTime, int endTime, int price){
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
}