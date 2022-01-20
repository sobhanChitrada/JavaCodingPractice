package coding;

public class MaxSubStringPalindrom {
    public static void main(String[] args) {
        String inputString = "aacbbbbaa";
        System.out.println(maxSubStringPalindrom(inputString));
    }

    private static String maxSubStringPalindrom(String inputString){

        if(inputString == null || inputString.length() < 1){
            return "";
        }
        int start=0; int end =0 ;
        for (int i = 0; i< inputString.length();i++){
            int len1 = expandFromMiddle(inputString, i, i);
            int len2 = expandFromMiddle(inputString, i, i+1);

            int len = Math.max(len1, len2);
            if(len > end-start){
                start = i - ((len-1)/2);
                end = i + (len/2);
            }

        }
        return inputString.substring(start, end+1);
    }

    private static int expandFromMiddle(String subString, int left, int right){

        if(subString == null || left > right){
            return 0;
        }
        while(left >= 0 && right < subString.length() && subString.charAt(left) == subString.charAt(right)){
                left --;
                right ++;
        }
        return right-left-1;
    }

}


/*
private static String maxSubStringPalindrom(String inputString){
        if(inputString == null || inputString.length() < 1){
            return "";
        }
        int start = 0, end =0;
        for (int i = 0; i < inputString.length(); i++){
            int len1 = expandFromMiddle(inputString, i, i);
            int len2 = expandFromMiddle(inputString, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end-start){
                start = i - ((len-1)/2);
                end = i + (len/2);
            }
        }
        return inputString.substring(start, end+1);
    }

    private static int expandFromMiddle(String subString, int left, int right){

        if(subString.length() < 1 && left > right){
            return 0;
        }

        while(left >=  0 && right < subString.length() && subString.charAt(left) == subString.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
 */