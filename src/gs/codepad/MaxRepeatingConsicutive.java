package gs.codepad;

public class MaxRepeatingConsicutive {
    public static void main(String[] args) {
        System.out.println(maxRepeatingChar("aaaaasbccccccccccccccccccdddddddddddd"));
    }
    private static char maxRepeatingChar(String str){
        char res = str.charAt(0);
        int count=0, curr_count = 1, n = str.length();

        for (int i =0; i < n; i++){
            if(i < n-1 && str.charAt(i) == str.charAt(i+1)){
                curr_count++;
            }else{
                if(count < curr_count){
                    count = curr_count;
                    res = str.charAt(i);
                }
                curr_count = 1;
            }
        }

        return res;
    }
    private static char maxRepeating(String str){
        char res = str.charAt(0);
        int count = 0, n = str.length(), curr_count = 1;

        for(int i=0; i < n; i++){
            if(i < n-1 && str.charAt(i) == str.charAt(i+1)){
                curr_count++;
            }else{
                if(count < curr_count){
                    count = curr_count;
                    res = str.charAt(i);
                }
                curr_count =1;
            }
        }
        return res;
    }
}
