package gs.codepad;

import java.util.ArrayList;

public class StudentWithMaxAverageScore {
    public static void main(String[] args) {
        String[] file = { "Shrikanth", "20", "30", "10", "Ram", "100", "50", "10" };
        studentWithMaxAverageScore(file);
    }
    //iterate the file data, for iteratation increment the index to the next 4th element since it is best average marks 3
    //after the name , next 3 indexes occupies the marks
    //for each iteration add the 1,2,3 index marks and total divided by 3
    //now compare average score with previous average ,
    // if it is best then clear previoud name and add the new best average score student name
    //and override the bestAverage = avgMarks

    private static void stduentsWithBestAvearge(String[] file){

        ArrayList<String> bestAvgStduentNames = new ArrayList<>();
        int avgMarks;
        int bestAvergae = Integer.MIN_VALUE;
        for(int i =0; i < file.length; i+=4){
            avgMarks = (Integer.parseInt(file[i+1])+Integer.parseInt(file[i+2])+Integer.parseInt(file[i+3]))/3;
            if(avgMarks > bestAvergae){
                bestAvergae = avgMarks;
                bestAvgStduentNames.clear();
                bestAvgStduentNames.add(file[i]);
            }else if(avgMarks == bestAvergae){
                bestAvgStduentNames.add(file[i]);
            }
        }
        bestAvgStduentNames.stream().forEach(names -> System.out.print(names + " "));
        System.out.println(bestAvergae);
    }


    private static void studentWithMaxAverageScore(String[] file){
        int avgScore;
        int maxAvgScore = Integer.MIN_VALUE;

        ArrayList<String> maxAvgStudents = new ArrayList();
        for(int i = 0; i < file.length; i+=4) {
            avgScore = (Integer.parseInt(file[i+1]) + Integer.parseInt(file[i+2]) +
                    Integer.parseInt(file[i+3]))/3;
            if(avgScore > maxAvgScore){
                maxAvgScore = avgScore;
                maxAvgStudents.clear();
                maxAvgStudents.add(file[i]);
            }else {
                maxAvgStudents.add(file[i]);
            }
        }

       maxAvgStudents.stream().forEach(name -> System.out.print(name + " "));
        System.out.println(maxAvgScore);
    }
}
