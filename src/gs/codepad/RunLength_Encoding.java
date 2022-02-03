package gs.codepad;// Java program to implement run length encoding

//https://www.geeksforgeeks.org/run-length-encoding/
public class RunLength_Encoding {

    private static String runLen(String str){
        String result = "";
        int count = 0;
        for (int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }
            System.out.println(str.charAt(i)+""+ count);
        }

        return result;
    }
    public static void printRLE(String str)
    {
        int n = str.length();
      int count = 1;
        for (int i = 1; i < n; i++) {

            // Count occurrences of current character
            
            if(str.charAt(i) == str.charAt(i-1)){
              count++;
            }
          else{
            count = 1;
          }

            // Print character and its count
            System.out.print(str.charAt(i));
            System.out.print(count);
        }
    }

    public static void main(String[] args)
    {
        String str = "wwwwaaadexxxxxxywww";
        printRLE(str);
    }
}