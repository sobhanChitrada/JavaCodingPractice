package gs.codepad;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        findFirstNonRepeatingChar("geeksforgeeks");
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
        int result=Integer.MAX_VALUE, i;
        for (Map.Entry<Character, CountIndex> entry: map.entrySet()) {
            int c = entry.getValue().count;
            int index = entry.getValue().index;
            if(c == 1 && index < result){
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
