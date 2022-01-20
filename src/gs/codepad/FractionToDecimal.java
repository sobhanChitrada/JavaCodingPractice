package gs.codepad;

import java.util.HashMap;

public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToStringDecimal(2, 3));
    }
    private static String fractionToStringDecimal(int numerator, int denominator){

        if(numerator == 0){
            return "0";
        }
        if(denominator == 0){
            return "";
        }
        String result = "";
        if((numerator < 0) ^ (denominator < 0)){
            result += "-";
        }

        long num = numerator, den = denominator;
        long res = num/den;
        result += String.valueOf(res);

        long reminder = (num%den)* 10;

        if(reminder == 0){
            return result;
        }else {
            result += ".";
        }
        HashMap<Long, Integer> map = new HashMap();
        while(reminder == 0){
            if(map.containsKey(reminder)){
                int sep = map.get(reminder);
                String part1 = result.substring(0, sep);
                String part2 = result.substring(sep, result.length());
                result = part1 + "(" + part2 + ")";
            }
            map.put(reminder, result.length());
            res = reminder / den;
            reminder = (reminder%den) * 10;
            result = String.valueOf(res);
        }
        return "";
    }

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
}
