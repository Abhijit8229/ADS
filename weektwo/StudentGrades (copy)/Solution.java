import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution{


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Map<String,List<String>> dict= new TreeMap<>();
        Input(sc,dict);
       
        
    }
    public static void addStudent(Map<String,List<String>> dict,String name,String rollno,int marks){
        char grade = marks >= 90 ? 'A' :( marks >= 80  && marks < 90) ? 'B' : (marks >= 70  && marks < 80)? 'C' :'D';
        String Marks = "" + marks;
        String Grade = "" + grade;
        List<String> temp = new ArrayList<String>();
        temp.add(name);
        temp.add(Marks);
        temp.add(Grade);
        dict.put(rollno,temp);
    }

    public static void DisplayStudents(Map<String,List<String>> dict){
        int count = 0;
        int size = dict.size();
        for(Map.Entry<String,List<String>> it : dict.entrySet()){
            count++;
            if(count == size) {
                System.out.printf("Name: %s, Roll Number: %s, Marks: %s, Grade: %s", it.getValue().toArray()[0], it.getKey()  , it.getValue().toArray()[1], it.getValue().toArray()[2]);
            } else {
                System.out.printf("Name: %s, Roll Number: %s, Marks: %s, Grade: %s\n",it.getValue().toArray()[0], it.getKey(), it.getValue().toArray()[1], it.getValue().toArray()[2]);
            }
        }
    }

    public  static void CalculateAverageMarks(Map<String,List<String>> dict){
        double totalNumberOfStudents = dict.size();  
        int sum  = 0;
        for(Map.Entry<String,List<String>> it : dict.entrySet()){
            sum+=Integer.parseInt(""+it.getValue().toArray()[1]);
        }
        double avg = sum/totalNumberOfStudents;
        System.out.printf("\nAverage Marks: %.2f",avg);

    }
    public static void Input(Scanner sc,Map<String,List<String>> dict){
        while (sc.hasNextLine()) {
            String[] Line = sc.nextLine().split(" ");
            if (Line[0].equals("Add")) {
                addStudent(dict,Line[2].substring(0,Line[2].length()-1),Line[3].substring(0,Line[3].length()-1),Integer.parseInt(Line[4].substring(0,Line[4].length())));
                
            }
            else if(Line[0].equals("DisplayStudents")){
                DisplayStudents(dict);
            }
            else if(Line[0].equals("CalculateAverageMarks")){
                CalculateAverageMarks(dict);
            }
        } 
        
    }
    
}



