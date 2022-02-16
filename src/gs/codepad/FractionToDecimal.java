package gs.codepad;

import java.util.HashMap;
import java.util.HashSet;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";
        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fractionToDecimal_(269, 3));
    }

    private static String fractionToDecimal_(int numerator, int denominator) {

       if(numerator == 0){
           return "0";
       }
       if(denominator == 0){
           return "";
       }
       String result = "";
       if((numerator<0) ^  (denominator<0) ){
           result += "-";
       }

       int num = numerator/denominator;
       result += String.valueOf(num);

       int reminder = numerator%denominator * 10;

       if(reminder == 0){
           return result;
       }

        HashMap<Integer, Integer> map = new HashMap<>();
       result += ".";
       while (reminder != 0){
           if(map.containsKey(reminder)){
               int separator = map.get(reminder);
               String s1 = result.substring(0, separator);
               String s2 = result.substring(separator, result.length());
               result = s1+"("+s2+")";
               return result;
           }
           map.put(reminder, result.length());
           num = reminder/denominator;
           result+=String.valueOf(num);
           reminder=reminder%denominator*10;
       }
        return result;
    }
}
