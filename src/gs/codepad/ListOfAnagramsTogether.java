package gs.codepad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListOfAnagramsTogether {
    public static void main(String[] args) {
        String arr[] = { "cat", "dog", "tac", "god", "act" };
        printAnagrams(arr);
    }

    private static void printAnagrams(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i =0; i < arr.length; i++){

            String oldWord = arr[i];
            char[] ch = oldWord.toCharArray();
            Arrays.sort(ch);
            String newWord = new String(ch);

            if(map.containsKey(newWord)){
                map.get(newWord).add(oldWord);
            }else{
                ArrayList<String> al = new ArrayList();
                al.add(oldWord);
                map.put(newWord, al);
            }
        }
        for(String key:map.keySet()){
            List<String> s= map.get(key);

            if(s.size()>1){
                System.out.println(s);
            }
        }
    }
}
