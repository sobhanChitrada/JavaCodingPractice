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

class SolutionMethod {
    private static List<IntervalCoderPad> minPriceIntervals(List<IntervalCoderPad> inputList){

        //Find MAX and MIN intervals in the input list
        int max_time = 0, min_time = 25;
        for(IntervalCoderPad in : inputList){
            if(in.startTime < min_time) {
                min_time = in.startTime;
            }
            if(in.endTime > max_time){
                max_time = in.endTime;
            }
        }

        //create an array with size of max-min && populate the array with MAX INTEGER values
        int arr[] = new int[max_time - min_time];
        for (int i =0; i < arr.length; i++){
            arr[i] = Integer.MAX_VALUE;
        }

        //populate array with specific interval price
        for (IntervalCoderPad in:inputList) {
            int c = in.endTime - in.startTime;
            int i = in.startTime - 1;
            while (c > 0){
                if(arr[i] > in.price){
                    arr[i] = in.price;
                }
                i++;
                c--;
            }
        }
        int start_time = 0, end_time =1, price =0;
        ArrayList<IntervalCoderPad> outputList = new ArrayList<>();
        while(end_time < arr.length){
            int start = end_time;

            while(end_time < arr.length && arr[start_time] == arr[end_time]){
                price = arr[start_time];
                start_time = start_time+1;
                end_time = end_time + 1;
            }

            if(end_time == arr.length){
                outputList.add(new IntervalCoderPad(start, end_time + 1, price));
                return outputList;
            } else if(arr[start_time] != arr[end_time]){
                outputList.add(new IntervalCoderPad(start, end_time + 1, price));
                price = arr[end_time];
                start_time = end_time;
                end_time = end_time+1;
            }
        }
        return outputList;
    }
    private static List<IntervalCoderPad> minimumPriceIntervals(List<IntervalCoderPad> inputList){
        int max_time = 0, min_time = 25;
        for(IntervalCoderPad list : inputList){
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
        for(IntervalCoderPad list : inputList){
            int c = list.endTime - list.startTime;
            int i = list.startTime - 1;
            while(c > 0){
                if(list.price < arr[i])
                    arr[i] = list.price;
                i++;
                c--;
            }
        }
        List<IntervalCoderPad> outputList = new ArrayList<>();

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
                outputList.add(new IntervalCoderPad(start, end_time+1, item_price));
                return outputList;
            } else if(arr[start_time] != arr[end_time]){
                outputList.add(new IntervalCoderPad(start, end_time+1, item_price));
                item_price = arr[end_time];
                start_time = end_time;
                end_time = end_time + 1;
            }
        }

        return outputList;

    }

    public static void main(String[] args) {
        List<IntervalCoderPad> inputList = new ArrayList<IntervalCoderPad>();
        inputList.add(new IntervalCoderPad(1, 5, 20));
        inputList.add(new IntervalCoderPad(3, 8, 15));
        inputList.add(new IntervalCoderPad(7, 10, 8));
        /*1 3 20
            3 7 15
            7 10 8*/
       List<IntervalCoderPad> outputList = minimumPriceIntervals(inputList);
        for(IntervalCoderPad list : outputList)
            System.out.println(list.startTime+" "+list.endTime+" "+list.price);
    }
}
