package gs.codepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Interval {
    int startTime;
    int endTime;
    int price;

    Interval(int startTime, int endTime, int price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
    @Override
    public String toString() {
        return "(" + startTime + ", " + endTime + ", " + price + ")";
    }
}


public class Solution_With_Mp {
    
    private static List<Interval> getLowestPrices(List <Interval> Intervals) {
        
        // HashMap doesn't provide any guarantee over the way the elements are arranged in the Map
        // However, items in a TreeMap are sorted according to their natural order.
        // we need startTime in increasing order to make intervals and find min price of that interval
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(Interval interval : Intervals) {
            for(int i = interval.startTime ; i <= interval.endTime ; i++) {
                if(map.containsKey(i)) {
                    if(interval.price < map.get(i)) {
                        map.put(i, interval.price);
                    } 
                } else {
                    map.put(i, interval.price);
                }
            }
        }
        
        List<Interval> result = new ArrayList<>();
        // For every entry check if price of current entry and last entry in result list is same then just update the endTime in result list
        // if not just add entry in result list
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(result.size() > 0 && result.get(result.size() - 1).price == entry.getValue()) {
                result.get(result.size() - 1).endTime = entry.getKey();
            } else {
                result.add(new Interval(entry.getKey(), entry.getKey(), entry.getValue()));
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<Interval> inputList = new ArrayList<>();
        inputList.add(new Interval(1, 5, 20));
        inputList.add(new Interval(3, 8, 15));
        inputList.add(new Interval(7, 10, 8));
        List<Interval> outputList = getLowestPrices(inputList);
        
        for(Interval interval : outputList)
            System.out.println(interval.toString());
    }
}