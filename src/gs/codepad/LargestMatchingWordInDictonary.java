package gs.codepad;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/760987/hard-problem-was-asked-in-goldman-sachs-please-solve

public class LargestMatchingWordInDictonary {
    public static List<String> longestMatcingWord(List<String> words, String input) {
        //Create a bucket to store frequencies of the input string letters. (I am assuming the string contains lowercase letters only)
        int[] bucket = new int[26];
        int maxLen = 0;
        List<String> res = new ArrayList<>();
        for(char c: input.toLowerCase().toCharArray()) {
            bucket[c-'a']++;
        }

        for(String word: words) {
            // Check if the word can be made using the letters in the bucket.
            if(canBeMade(bucket.clone(),word)) {
                if(word.length() == maxLen) { // If we find a word same as the longest word, add it to the list.
                    res.add(word);
                } else if(word.length() > maxLen) { // If we find a longer word, clear the list and add the new word and update the len.
                    res.clear();
                    res.add(word);
                    maxLen = word.length();
                }
            }
        }
        return res;
    }

    private static boolean canBeMade(int[] bucket,String word) {
        for(int i = 0;i<word.length(); i++) {
            if(bucket[word.charAt(i) - 'a'] == 0) { // if the input does not contain that letter, we don't proceed since the word cant be made.
                return false;
            } else {
                bucket[word.charAt(i) - 'a']--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
       /* List<String> dicto = new ArrayList<>();
        dicto.add("ale");
        dicto.add("apple");
        dicto.add("paple");
        dicto.add("monkey");
        dicto.add("plea");
        String letters = "abpcplea";
        System.out.println(wordDict_(dicto, letters));*/

        List<String> dicto = new ArrayList<>();
        dicto.add("to");
        dicto.add("banana");
        dicto.add("toe");
        dicto.add("dogs");
        dicto.add("ababcd");
        dicto.add("elephant");
        String letters = "eot";
        System.out.println(longestMatcingWord(dicto, letters));
    }
}
