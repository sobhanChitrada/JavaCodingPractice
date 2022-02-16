package gs.codepad;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommentsInCPlusPrpgram {
    public static List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) { // mode 1: /**/
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                } else {  // mode 2: //
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;           //skip '*' on next iteration of i
                    } else {
                        sb.append(s.charAt(i));     //not a comment
                    }
                }
            }
            if (!mode && sb.length() > 0) { // no comments or // comment
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }
    public static void main(String args[]) {
        String source[] = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(removeComments(source));
    }
    //[int main(), { ,   , int a, b, c;, a = b + c;, }]
    //[int main(), { ,   , int a, b, c;, a = b + c;, }]
    private static List<String> removeComments_(String[] source) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> res= new ArrayList();
        boolean mode = false;
        for(String s: source){
            for(int i=0;i<s.length();i++){
                if(mode){
                    if(s.charAt(i)=='*' && i<s.length()-1 && s.charAt(i+1) == '/'){
                        mode=false;
                        i++;
                    }
                }else{
                    if(s.charAt(i)=='/' && i<s.length()-1 && s.charAt(i+1) == '/'){
                        break;
                    }else if(s.charAt(i)=='/' && i<s.length()-1 && s.charAt(i+1) == '*'){
                        mode=true;
                        i++;
                    }else{
                        sb.append(s.charAt(i));
                    }
                }
            }
            if(!mode && sb.length()>0){
                res.add(sb.toString());
                sb= new StringBuilder();
            }
        }
        return res;
    }


}


