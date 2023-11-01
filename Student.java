import java.util.Scanner;
public class Student extends Days{
        /* Each student has its own "Attendance Array". */
        String name;
        int rollNo;

        boolean[] Attendance;
        public Student(int totalDays){
                this.totalDays = totalDays;
                Attendance = new boolean[totalDays];
        }

        void setAttendance(boolean attendance, int dayIndex){
                Attendance[dayIndex] = attendance;
        }

        void Administration(){
                Scanner sStudent = new Scanner(System.in);

                System.out.println("");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("SIGNED IN AS " + name + '\n');
                int Operation;
                System.out.println("Choose the operation:");
                System.out.println("1. Know your percentage attendance");
                System.out.println("2. Know your eligibility for Mid sems");
                System.out.println("3. Know your eligibility for End sems");
                System.out.print("Please enter the index:");
                Operation = sStudent.nextInt();

                float TotalAttend = 0;
                        for(int i = 0; i<Attendance.length; i++){
                                if(Attendance[i] == true){
                                        TotalAttend ++;
                                }
                        }
                        float PerAttend = (TotalAttend/Attendance.length)*100;

                switch(Operation){ 
                        

                        case 1: System.out.println("Your total attendance is: " + "||\t" +PerAttend+ '%'+ "\t||");
                                break;
                        case 2: if(PerAttend >= 60){
                                System.out.println("You are Eligible for MST");
                                }
                                else{
                                        System.out.println("Not eligible");
                                }
                                break;
                        case 3: if(PerAttend >= 75){
                                System.out.println("You are eligible for End sems");
                                }
                                else{
                                System.out.println("Not eligible");
                                }

                        }

                }
        }