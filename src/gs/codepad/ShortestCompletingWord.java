package gs.codepad;

//https://leetcode.com/problems/shortest-completing-word/

import java.util.HashMap;

public class ShortestCompletingWord {

    private static String shortestCompletingWord(String licensePlate, String[] words){
        String minWord="";
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: licensePlate.toLowerCase().toCharArray()){
            if(c >= 'a' && c <= 'z') {
                increment(map, c, 1);
            }
        }
        for (String word: words) {
            if(minLen > word.length()){
                HashMap<Character, Integer> cloneMap = (HashMap<Character, Integer>) map.clone();
                for (Character c: word.toCharArray()) {
                   increment(cloneMap, c, -1);
                }
                if(cloneMap.size() == 0){
                    minLen = word.length();
                    minWord = word;
                }
            }
        }
        return minWord;
    }
    private static void increment(HashMap<Character, Integer> map, Character c, int delta) {
        int newValue = map.getOrDefault(c, 0);
        newValue += delta;
        if(newValue == 0){
            map.remove(c);
        }else if(newValue > 0){
            map.put(c, newValue);
        }
    }

    public static void main(String[] args) {
        //String licensePlate = "1s3 PSt"; String words[] = new String[]{"step","steps","stripe","stepple"};

        String licensePlate = "1s3 456"; String words[] = {"looks","stew","show","pest"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }
    //https://leetcode.com/problems/shortest-completing-word/discuss/110137/Java-Solution-using-character-Array
}