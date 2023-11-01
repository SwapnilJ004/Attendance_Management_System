import java.util.*;

public class Teacher extends Student{
    String name;
    List<Student> StudList = new ArrayList<Student> ();

    Teacher(int totalDays,Student stud){
            super(totalDays);
            StudList.add(stud); 
    }

    void Administration(){
        Scanner sTeacher = new Scanner(System.in);

        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("WELCOME "+name+" Mam/Sir\n\n");
        int Operation;
        System.out.println("Please choose the operation:");
        System.out.println("1. Calculate percentage attendance of all students");
        System.out.println("2. Calculate eligibility of all students in mid sems");
        System.out.println("3. Calculate eligibility of all students in end sems");
        System.out.println("4. Print Daywise attendance of all students");

        System.out.print("Please select one of the corresponding index:");
        Operation = sTeacher.nextInt();

        if(Operation == 1){
            float percAttend = 0;
            for(int i = 0; i<StudList.size(); i++){
                System.out.print(StudList.get(i).name + ": ");
                for(int j = 0; j<totalDays; j++){
                    if(StudList.get(i).Attendance[j] == true){
                        percAttend++;
                    }
                }
                float total = (percAttend/totalDays)*(100);
                // System.out.println(percAttend+" "+totalDays);
                System.out.println(total +"%");
                // System.out.println(StudList.size()+" "+ i);
                
            }
        }
        else if(Operation == 2){
            for(int i = 0; i<StudList.size(); i++){
                System.out.print(StudList.get(i).name +": ");
                float percAttend = 0;
                for(int j = 0; j<totalDays; j++){
                    if(Attendance[j] == true){
                        percAttend++;
                    }
                }
                percAttend = (percAttend/totalDays)*100;
                if(percAttend >= 60){
                    System.out.println("Eligible");
                }
                else{
                    System.out.println("Not eligible");
                }
            }
        }
        else if(Operation == 3){
            for(int i = 0; i<StudList.size(); i++){
                System.out.println(StudList.get(i).name +": ");
                float percAttend = 0;
                for(int j = 0; j<totalDays; j++){
                    if(StudList.get(i).Attendance[j] == true){
                        percAttend++;
                    }
                }
                percAttend = (percAttend/totalDays)*100;
                if(percAttend >= 75){
                    System.out.println("Eligible");
                }
                else{
                    System.out.println("Not eligible");
                }
            }
        }
        else if(Operation == 4){
            for(int i = 0; i<StudList.size(); i++){
                System.out.print(StudList.get(i).name + ": " );
                for(int j = 0; j<totalDays; j++){
                    if (StudList.get(i).Attendance[j] == false){
                        System.out.print('A' + "\t");
                    }
                    else{
                        System.out.print('P' + "\t");
                    }
                }

                System.out.println("");
            }
        }
        else{
        System.out.println("Please enter a valid index");
        }
    }
}