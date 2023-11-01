import java.util.*;
import java.lang.*;

//We will typecast false as Absent and True as Present for the current Day

class Main{
    //Calling Class:
    public static void main(String args[]){
        Scanner sMain = new Scanner(System.in);
        Scanner sMain2 = new Scanner(System.in);
        System.out.println("Welcome to the Attendance Management System");
        System.out.println("--------------------------");
        System.out.println("");
        System.out.println("Entering Student Database :-");
        System.out.println("");

        Days TotalDays = new Days();
        try{
            TotalDays.getTotalDays();
        }
        catch(InputMismatchException ipTotalDays){
            System.out.println("Please enter a valid integer");
            System.exit(0);
        }

        Student stud1 = new Student(TotalDays.totalDays);
        Student stud2 = new Student(TotalDays.totalDays);
        // Student stud3 = new Student();
        // Student stud4 = new Student();
        // Student stud5 = new Student();


        List<Student> StudList = new ArrayList<Student> ();

        StudList.add(stud1);
        StudList.add(stud2);
        // StudList.add(stud3);
        // StudList.add(stud4);
        // StudList.add(stud5);


        System.out.print("Name of student 1:");
        String name = sMain.nextLine();
        stud1.name = name;
        System.out.print("Enter the Roll No of Student 1:");
        stud1.rollNo = sMain.nextInt();

        System.out.println("");

        System.out.print("Name of student 2:");
        stud2.name = sMain2.nextLine();
        System.out.print("Enter the Roll No of Student 2:");
        stud2.rollNo = sMain.nextInt();

        // System.out.print("Name of student 3:");
        // stud3.name = sMain.nextLine();
        // System.out.print("Enter the Roll No of Student 3:");
        // stud3.rollNo = sMain.nextInt();

        // System.out.print("Name of student 4:");
        // stud4.name = sMain.nextLine();
        // System.out.print("Enter the Roll No of Student 4:");
        // stud4.rollNo = sMain.nextInt();

        // System.out.print("Name of student 5:");
        // stud5.name = sMain.nextLine();
        // System.out.print("Enter the Roll No of Student 5:");
        // stud5.rollNo = sMain.nextInt();

        System.out.println("________________________________\n");

        Teacher teacher1 = new Teacher(TotalDays.totalDays,StudList.get(0));
        Teacher teacher2 = new Teacher(TotalDays.totalDays,StudList.get(0));
        
        for(int i = 0; i<StudList.size()-1; i++){
            teacher1.StudList.add(StudList.get(i+1));
        }

        Scanner sMain1 = new Scanner(System.in);
        System.out.print("Please enter the name of Teacher1:");
        teacher1.name = sMain1.nextLine();
        System.out.println("");
        System.out.print("Please enter the name of Teacher2:");
        teacher2.name = sMain1.nextLine();

        for(int i = 0; i<TotalDays.totalDays; i++){
            System.out.println("-------------------------\n\n");
            System.out.print("ATTENDANCE OF DAY:");
             System.out.println(i+1);
            for(int j = 0; j<StudList.size(); j++){
                CurrentDay(StudList.get(j),i);
            }
            
            System.out.println("");

            if(i<TotalDays.totalDays - 1){
                System.out.print("Begin Day" + (i+2) + "? (Please Enter 1 for Yes and any other integer for No):");
                int EnterNextDay;
                try{
                    EnterNextDay = sMain.nextInt();
                }
                catch(InputMismatchException loopRefVar){
                    EnterNextDay = 0;
                }
                
                if(EnterNextDay == 1){
                    continue;
                }
                else{
                    System.out.print("Enter any key to continue:");
                    char Wait = sMain.next().charAt(0);
                }
            }
        }
        
        // sMain.close();
        System.out.println("______________________________________" +'\n');
        System.out.println("Successfully marked attendance\n");
        System.out.println("_____________________________________");
        
        int profile;
        System.out.println("Please choose your profile:");
        System.out.println("1.Teacher");
        System.out.println("2.Student");
        System.out.print("Please enter the corresponding index:");
        profile = sMain.nextInt();

        if(profile == 1){
            String profName;
            System.out.println("Please enter through login credentials:");
            System.out.print("Please enter your name:");
            profName = sMain1.nextLine();
            if(teacher1.name.equals(profName)){
                teacher1.Administration();
            }
            else if(teacher2.name.equals(profName)){
                teacher2.Administration();
            }
            else{
                System.out.println("Teacher profile do not match");
            }
        }
        else{
            String LoginStudName;
            System.out.println("Please login through your credentials:");
            System.out.print("Enter your name:");
            LoginStudName = sMain1.nextLine();
            
            boolean searchProfFlag = false;
            for(int i = 0; i<StudList.size(); i++){
                if(LoginStudName.equals(StudList.get(i).name)){
                    StudList.get(i).Administration();
                    searchProfFlag = true;
                    break;
                }
            }

            if(searchProfFlag == false){
                System.out.println("Profile not found!");
            }
        }

        System.out.println("");
        System.out.println("Thank you for using attendance portal!\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void CurrentDay(Student stud, int whichDay){
        Scanner attend = new Scanner(System.in);
        System.out.print("Please enter attendance for " + stud.name +": ");
        char ScanAttendce = attend.next().charAt(0);

        boolean isAttending = false;
        if(ScanAttendce == 'A' || ScanAttendce == 'a' || ScanAttendce == '0'){
            isAttending = false;
            stud.setAttendance(isAttending,whichDay);
        }
        else if(ScanAttendce == 'P' || ScanAttendce == 'p' || ScanAttendce == '1'){
            isAttending = true;
            stud.setAttendance(isAttending,whichDay);
        }
        else {
            System.out.println("Please enter a valid attendance");
        }
        
        if(isAttending == true){
             System.out.println("Marked Present");
        }
        else{
            System.out.println("Marked Absent");
        }
    }
}