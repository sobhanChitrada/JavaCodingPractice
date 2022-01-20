package gs.codepad;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElementInAnArray {
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 1, 3, 2, 1,3,3,3,3,3,5};
        int n = arr.length;

        System.out.println(mostFrequent_(arr,n));
    }
    private static int mostFrequent_(int arr[], int n){
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i< n; i++){
            if(hm.containsKey(arr[i])){
                int value = hm.get(arr[i]);
                hm.put(arr[i], value+1);
            }else{
                hm.put(arr[i], 1);
            }
        }
        int max_count =0;
        Integer res =0;
        for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {

            if(max_count < entry.getValue()){
                res = entry.getKey();
                max_count = entry.getValue();
            }

        }
        return res;
    }
    static int mostFrequent(int arr[], int n)
    {

        // Insert all elements in hash
        Map<Integer, Integer> hp =
                new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++)
        {
            int key = arr[i];
            if(hp.containsKey(key))
            {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            }
            else
            {
                hp.put(key, 1);
            }
        }

        // find max frequency.
        int max_count = 0, res = -1;

        for(Map.Entry<Integer, Integer> val : hp.entrySet())
        {
            if (max_count < val.getValue())
            {
                res = val.getKey();
                max_count = val.getValue();
            }
        }

        return res;
    }
}
