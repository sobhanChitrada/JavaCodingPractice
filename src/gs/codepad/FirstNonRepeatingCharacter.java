package gs.codepad;

import java.util.HashMap;
import java.util.Map;

//create an class that holds both character index and its count. method to increment the counter
//Create a map which has the key as a Character, value as its CounterIndex object
//Iterate each char of the given string, populate the map the each character and its counterIndex object
//Once populated the map iterate the map values, if any character count 1 and its first occurred then return the index

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        findFirstNonRepeatingChar("geeksffzorgeeks");
    }

    private static void findFirstNonRepeatingChar(String string){
        final int NO_CHAR= 256;
        HashMap<Character, CountIndex> map = new HashMap<>(NO_CHAR);

        for (int i = 0; i < string.length(); i++){
            if(map.containsKey(string.charAt(i))){
                map.get(string.charAt(i)).incCount();
            }else {
                map.put(string.charAt(i), new CountIndex(i));
            }
        }
        int result=Integer.MAX_VALUE;
        for (Map.Entry<Character, CountIndex> entry: map.entrySet()) {
            int c = entry.getValue().count;
            int index = entry.getValue().index;
            if(c == 1 && index < result) {
                result = index;
            }
        }
        System.out.println(string.charAt(result));
    }
}

class CountIndex {
   int count;
   int index;
   public CountIndex(int index){
       this.count = 1;
       this.index = index;
   }
   public void incCount(){
       this.count++;
   }
}

//https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
