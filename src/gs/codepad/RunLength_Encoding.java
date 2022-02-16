package gs.codepad;// Java program to implement run length encoding

//https://www.geeksforgeeks.org/run-length-encoding/
public class RunLength_Encoding {

    public static void printRLE(String str)
    {
        int n = str.length();
        int count = 1;
        int i = 1;
        String result = "";
        for (i = 1; i < n; i++) {

            // Count occurrences of current character
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            }
            else {
               /* System.out.print(str.charAt(i - 1));
                System.out.print(count);*/
                result += str.charAt(i - 1)+""+count;
                count = 1;
            }
        }
        // Print character and its count for the last
        // character
        result += str.charAt(i - 1)+""+count;
        System.out.print(result);
    }

    public static void main(String[] args)
    {
        String str = "zaaaabbbbccccddddd";
        printRLE_(str);
    }

    private static void printRLE_(String str) {
        String result ="";
        int count =1;
        int i=1;
        for( i=1; i< str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                result += str.charAt(i-1)+""+count;
                count=0;
            }
        }
        result += str.charAt(i-1)+""+count;
        System.out.println(result);
    }
}