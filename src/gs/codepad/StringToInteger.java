package gs.codepad;

import java.util.Locale;

public class StringToInteger {

    private static int atoi(String string){
        if(string == null ||string.length() < 1) {
            return 0;
        }
        string = string.trim();
        char flag = '+';
        int index = 0;
        if(string.charAt(0) == '+'){
            index++;
        }else if(string.charAt(0) == '-'){
            flag = '-';
            index++;
        }

        double result = 0;
        while(string.length() > index && string.charAt(index) >= '0' && string.charAt(index) <= '9'){
            result = result * 10 + (string.charAt(index) - '0');
            index++;
        }
        if(flag == '-'){
            result = -result;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else {
            return (int)result;
        }
    }
    public static void main(String[] args) {
       String s = " sdsd 4193 with words";
        System.out.println(atoi(s));
    }
}
