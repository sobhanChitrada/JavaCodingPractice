package gs.codepad;

import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"Bob","87"}, {"Mike", "100"},
                                          {"Jason","64"}, {"Mike", "22"}};
        bestAverageGrade(data);
    }

    //iterate the data and for each iteration first index is a name of the studnet which acts as key in the map
    //Value would be integer array which has double index
    //where the 1st index indicates the number of the times each name repeated i.e. total subjects
    //2nd index total marks

    private static void bestAverageGrade(String[][] data){

        Map<String, int []> studentAverageMarks = new HashMap<>();
        for (String[] studentData: data) {
            String studentName  = studentData[0];
            int marks = Integer.parseInt(studentData[1]);
            if(!studentAverageMarks.containsKey(studentName)){
                studentAverageMarks.put(studentName, new int[] {1, marks});
            }else{
                studentAverageMarks.get(studentName)[0]++;
                studentAverageMarks.get(studentName)[1] = studentAverageMarks.get(studentName)[1]+marks;
            }
        }
        int bestGrade = -1;
        for (int [] avgMarks :studentAverageMarks.values()) {
            bestGrade = Math.max(bestGrade, avgMarks[1]/avgMarks[0]);
        }
        System.out.println(bestGrade);
    }
}
