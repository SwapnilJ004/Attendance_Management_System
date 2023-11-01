import java.util.Scanner;
class Days{
    int totalDays;
    void getTotalDays(){
        Scanner dayScan = new Scanner(System.in);
        int noOfDays;
        System.out.print("Please enter the total number of days:");
        noOfDays = dayScan.nextInt();
        this.totalDays = noOfDays;
        // dayScan.close();
    }

    void Administration(){
        System.out.println("Unused method, used just for overriding");
    }
}