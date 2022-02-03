package gs.codepad;

import java.util.*;

public class FindMatchLongWordInDictionary {

    public static void main(String[] args) {
        List<String> dicto = new ArrayList<>();
        dicto.add("ale");
        dicto.add("eppla");
        dicto.add("paple");
        dicto.add("monkey");
        dicto.add("plea");
        String letters = "abpcplea";
        System.out.println(longestWord(dicto, letters));
    }

    private static String longestWord(List<String> dicto, String givenString) {
        String result = "";
       for(String dic:dicto) {
            if(isSubsequnce(givenString, dic)) {
                if(dic.length()>result.length() || (dic.length() == result.length() && dic.compareTo(result) < 1))
                result = dic;
            }
       }
        return result;
    }
    private static boolean isSubsequnce(String givenString, String dic) {
        int i =0, j=0;
       if(dic.length() > givenString.length()) {
           return false;
       }
       while( i< givenString.length() && j < dic.length()) {
           if(givenString.charAt(i) == dic.charAt(j)) {
               j++;
           }
           i++;
       }
       return dic.length() == j;
    }
}