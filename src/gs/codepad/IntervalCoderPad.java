package gs.codepad;

import java.util.ArrayList;
import java.util.List;

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
//find min_time , max_time in the intevals list
//create an array with max-min
//populate the arry max integer
//update array wiht acutal price
//start_time, end_time
//take list, if end_time < size
//until array [start_time] and [end_time] has the same prices then update the start_time and time
// if end== array_lenght => creat interval return the list
//if end_time != start_time do as above but not return then updated the index
class SolutionMethod {
    private static List<IntervalCoderPad> minPriceIntervals(List<IntervalCoderPad> inputList){

        //Find MAX and MIN intervals in the input list
        int max_time = 0, min_time =25;
        for (IntervalCoderPad ic: inputList){
            if(max_time < ic.endTime) {
                max_time = ic.endTime;
            }
            if(min_time > ic.startTime) {
                min_time = ic.startTime;
            }
        }
        //create an array with size of max-min && populate the array with MAX INTEGER values
        int arr[] = new int[max_time - min_time];
        for(int i=0; i< arr.length; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        //populate array with specific interval price
        for (IntervalCoderPad ic: inputList) {
            int c = ic.endTime - ic.startTime;
            int i = ic.startTime-1;
            while (c > 0){
                if(arr[i] > ic.price){
                    arr[i] = ic.price;
                }
                i++;
                c--;
            }
        }
        int start_time = 0, end_time = 1, price = 0;
        ArrayList<IntervalCoderPad> al = new ArrayList<>();

        while (end_time < arr.length) {
            int start = end_time;
            while((end_time < arr.length) && (arr[end_time] == arr[start_time])){
                 price = arr[end_time];
                 start_time = start_time + 1;
                 end_time = end_time + 1;
            }
            if(end_time == arr.length){
                al.add(new IntervalCoderPad(start, end_time+1, price));
                return al;
            }else if(arr[end_time] != arr[start_time]){
                al.add(new IntervalCoderPad(start, end_time+1, price));
                price = arr[end_time];
                start_time = end_time;
                end_time = end_time + 1;
            }
        }
        return al;
    }

    public static void main(String[] args) {
        List<IntervalCoderPad> inputList = new ArrayList<IntervalCoderPad>();
        inputList.add(new IntervalCoderPad(1, 5, 20));
        inputList.add(new IntervalCoderPad(3, 8, 15));
        inputList.add(new IntervalCoderPad(7, 10, 8));
        /*1 3 20
            3 7 15
            7 10 8*/

       List<IntervalCoderPad> outputList =  getIntervalList(inputList);
        for(IntervalCoderPad list : outputList)
            System.out.println(list.startTime+" "+list.endTime+" "+list.price);
    }
    private static List<IntervalCoderPad> getIntervalList(List<IntervalCoderPad> inputList){

        int min_time = 25, max_time = 0;

        for(IntervalCoderPad ic: inputList){
            if(ic.startTime < min_time){
                min_time = ic.startTime;
            }
            if(ic.endTime > max_time){
                max_time = ic.endTime;
            }
        }

        int price[] = new int[max_time - min_time];

        for(int i=0; i<price.length; i++){
            price[i] = Integer.MAX_VALUE;
        }

        for(IntervalCoderPad ic: inputList) {
            int c = ic.endTime - ic.startTime;
            int i = ic.startTime-1;
            while(c>0){
                if(ic.price < price[i]){
                    price[i] = ic.price;
                }
                i++;
                c--;
            }
        }
        ArrayList<IntervalCoderPad> al = new ArrayList();
        int start_time =0, end_time=1;
        int curr_price = 0;
        while(end_time < price.length){
            int start = end_time;
            while(end_time < price.length && price[start_time] == price[end_time]){
                curr_price = price[start_time];
                start_time = start_time +1;
                end_time = end_time +1;
            }
            if(end_time == price.length){
                al.add(new IntervalCoderPad(start, end_time+1, curr_price));
                return al;
            } else if(price[start_time] != price[end_time]){
                al.add(new IntervalCoderPad(start, end_time+1, curr_price));
                curr_price = price[end_time];
                start_time = end_time;
                end_time = end_time +1;
            }
        }
        return al;
    }
}
