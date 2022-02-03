package gs.codepad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BestAverageGrade {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"Bob","87"}, {"Mike", "100"},
                                          {"Jason","64"}, {"Mike", "22"}};
        bestAverage(data);
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
    private static void bestAverage(String[][] data){
        HashMap<String, int []> map = new HashMap<>();

        for (String [] stu : data){
            String name = stu[0];
            int score = Integer.parseInt(stu[1]);
            if(map.containsKey(name)){
                map.get(name)[0]++;
                map.get(name)[1] += score;
            }else{
                map.put(name, new int[]{1, score});
            }
        }
        int bestGrade = -1;
        /*for (int[] avgGrades : map.values()){
            bestGrade = Math.max(bestGrade, avgGrades[1]/avgGrades[0]);
        }*/
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, int[]> entry: map.entrySet()) {
            String name = entry.getKey();
            int[] avgGrades = entry.getValue();
            int avgGrade = avgGrades[1]/avgGrades[0];
            if(bestGrade < avgGrade){
                bestGrade = avgGrade;
                list.clear();
                list.add(name);
            }else if(bestGrade == avgGrade){
                list.add(name);
            }
        }
        list.stream().forEach(System.out::println);
    }
}
