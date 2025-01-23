import java.util.Scanner;

class WeekOneDayTwo{
    public void roots(int b, int c){
        double d = b*b - 4*c;
        double sqrt_val = Math.sqrt(Math.abs(d));
            System.out.println((-b + sqrt_val)/(2));
            System.out.println((-b - sqrt_val)/(2));
    }

    public void surfaceArea(int a, int b){
        int val = a*a;
        int val2 = b*b;
        System.out.println(2*val + 2*val2);
    }

    public void useThree(String a, String b, String c){
        System.out.printf("Hi %s, %s, and %s.", c, b, a);
    }

    public void FahrenheitToCelsius(double F){
        System.out.printf("%.1f", (5.0/9.0) * (F - 32));
    }
    public void Distance_Between_Points_Calculator(double x1,double y1,double x2, double y2){
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.printf("%.1f",distance);
    }
    public void Pythagorean_Theorem_Calculator(double a,double b){
        System.out.printf("%.1f", Math.sqrt(a*a + b*b));
    }
}

class WeekOneDayThree{
    public void Automated_Garden_Watering_System(boolean soil_dry, boolean raining, boolean day_time,int temperature){
        if(soil_dry && !raining && day_time && temperature > 10){
            System.out.println("True");
             return;
        }
        System.out.println("False");

    }


    public void Smart_Energy_Management_System(boolean house_occupied, boolean high_energy_appliance_on, boolean peak_hours,int current_energy_usage){
            if (!house_occupied || ((high_energy_appliance_on && peak_hours) && current_energy_usage > 50)){
                System.out.println("True");
                return;
                
            }
            System.out.println("False");
    }
    public void Smart_Home_Security_System(boolean door_open, boolean window_open, boolean motion_detected,boolean alarm_deactivated){
            if ((door_open || window_open || motion_detected) && !alarm_deactivated){
                System.out.println("True");
                return;
                
            }
            System.out.println("False");
    }
    public void The_Robot_Guamotion_detectedrdian(int age,boolean has_id,boolean knows_password){
        if (age >= 18 && has_id || knows_password){
            System.out.println("True");
            return;     
        }
        System.out.println("False");
    }
    public void The_Secret_Door(boolean action1, boolean action2, boolean action3){
        if ((action1 && action2 && action3)  || (action1 && action3) || (action2 && (action3||action1))){
            System.out.println("True");
            return;
        }
        System.out.println("False");

    }
}
class WeekOneDayFour{
    private Scanner sc;
    public WeekOneDayFour(Scanner sc){
            this.sc = sc;
    }
    public void Gym_Membership_Eligibility(){
        int age = sc.nextInt();
        double BMI = sc.nextDouble();
        boolean healthCondition = sc.nextBoolean();
        if ((age >= 18 && age<=60 && (BMI >= 18.5 && BMI<=24.9) && !healthCondition) || 
        (age<18 && (BMI > 18.5 && BMI < 24.9)) || 
        ((age>60 && (BMI >= 18.5 && BMI <= 24.9)) && !healthCondition)){
            System.out.println("True");
           
            return;
        }
        System.out.println("False");
       
        }
       
    public void  Home_Loan_Eligibility(){
        int age = sc.nextInt();
        double annual_income = sc.nextDouble();
        int credit_score = sc.nextInt();
        double current_debts = sc.nextDouble();
        if (((age >= 25 && age<=65) && (annual_income > 50000 && current_debts < 50000 && credit_score >= 700)) || 
             (age<25 && (annual_income > 70000 && current_debts < 30000 && credit_score >= 750))||
             (age>65 && (annual_income > 40000 && current_debts < 20000 && credit_score >= 650))){
            System.out.println("True");
            return;
        }
        System.out.println("False");

    }
    public void Difference_or_Sum(){
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a-b == 5 || b-a == 5 || a+b == 5){
            System.out.println("True");
            return;
        }
        System.out.println("False");
    }

    public void Fabric_Yarn(){
        int inches = sc.nextInt();
        System.out.println((int)Math.ceil((double)inches/36));
    }
    
    public void Egg_Carton(){
        int eggs = sc.nextInt();
        System.out.println((int)Math.ceil((double)eggs/12));
    }

    public void Perfect_Square(){
        int num = sc.nextInt();
        for (int i = 0; i <= num; i++){
            if (i*i == num){
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }
    public void Time_Conversion(){
        String Time = sc.nextLine();
        String[] time = Time.split(":");
        String hours = time[0];
        String minutes = time[1];
        String sec = time[2].substring(0,2);
        String period = time[2].substring(2,4);
        if (period.equals("PM") && !hours.equals("12")){
            hours = String.valueOf(Integer.parseInt(hours)+12);
        }
        if (period.equals("AM") && hours.equals("12")){
            hours = "00";
            
        }
        System.out.printf("%s:%s:%s",hours,minutes,sec);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeekOneDayFour obj = new WeekOneDayFour(sc);
        obj.Time_Conversion();
        sc.close();
    }
}

