package gs.codepad;

import java.util.*;
public class Intervals {
    int startTime;
    int endTime;
    int price;
    Intervals(int startTime, int endTime, int price)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
    public static void main(String[] args) {
        List<Intervals> list = new ArrayList<>();


        Intervals obj1 = new Intervals(1,5,20);
        Intervals obj2 = new Intervals(3,6,15);
        Intervals obj3 = new Intervals(2,8,25);
        Intervals obj4 = new Intervals(7,12,18);
        Intervals obj5 = new Intervals(1,30,22);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);
        list = getIntervals(list);
        System.out.println(list);
    }

    private static List<Intervals> getIntervals(List<Intervals> list) {
        Collections.sort(list, (a,b) -> a.startTime - b.startTime);
        List<Intervals> res = new ArrayList<>();
        int startTime = list.get(0).startTime;
        int endTime = list.get(0).endTime;
        int price = list.get(0).price;

        for(int i = 1; i < list.size(); i++)
        {
            Intervals current = list.get(i);
            // If the current startTime is less than previous startTime and there is a cheaper price. We append our previous startTime -> currentStartTime - 1 and update our start and endTimes
            if(current.startTime <= endTime && current.price < price)
            {
                res.add(new Intervals(startTime, current.startTime - 1, price));
                startTime = current.startTime;
                endTime = current.endTime;
                price = current.price;
            }
           //Else we simply add the startTime and endTime with their price and update.
            else
            {
                res.add(new Intervals(startTime, endTime, price));
                startTime = current.startTime;
                endTime = current.endTime;
            }
        }

        res.add(new Intervals(startTime, endTime, price));
        return res;
    }
}