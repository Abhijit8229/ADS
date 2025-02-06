import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
// import Utility.Utility;
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
        // System.out.println(String.);
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


class WeekOneDayFive {
    private Scanner sc;

    public WeekOneDayFive(Scanner sc) {
        this.sc = sc;
    }

    public void Calculate_Factorial() {
        int num = sc.nextInt();
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }

    public boolean checkPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] rotateArrayRight(int number) {
        String val = String.valueOf(number);
        int[] result = new int[val.length()];
        for (int i = 0; i < val.length(); i++) {
            String valResult = "" + val.charAt(val.length() - 1);
            for (int j = 0; j < val.length() - 1; j++) {
                valResult = valResult + val.charAt(j);
            }
            val = valResult;
            result[i] = Integer.parseInt(valResult);
        }
        return result;
    }

    public boolean isCircularPrime(int number) {
        int[] rotatedArray = rotateArrayRight(number);
        for (int i : rotatedArray) {
            if (!checkPrimeNumber(i)) {
                return false;
            }
        }
        return true;
    }

    public void nthcircularprime() {
        int number = sc.nextInt();
        int i = 0;
        int j = 0;
        while (i < number) {
            if (isCircularPrime(j)) {
                i++;
            }
            j++;
        }
        System.out.println(j - 1);
    }

    public void SquareDifferenceProblem() {
        long number = sc.nextLong();
        long sum = 0, squareSum = 0;
        long difference = 0;
        for (long i = 0; i <= number; i++) {
            sum += i;
            squareSum += i * i;
        }
        difference = (sum * sum) - squareSum;
        System.out.println(difference);
    }

    public void countOccurences() {
        String first = sc.nextLine();
        String second = sc.nextLine();
        int i = 0;
        int len = second.length();
        int j = 0;
        while (i < first.length()) {
            if (first.substring(i, len).equals(second)) {
                j++;
            }
            i++;
            if (len < first.length()) {
                len++;
            }
        }
        System.out.println(j);
    }

    public void stringcompressions() {
        String s = sc.nextLine();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            if (count != 1) {
                result += s.charAt(i) + "" + count;
            } else {
                result += s.charAt(i) + "";
            }
            i += count - 1;
        }
        System.out.println(result);
    }

    public List<Integer> primefactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (number != 1) {
                if (checkPrimeNumber(i) && number % i == 0) {
                    number = number / i;
                    factors.add(i);
                } else {
                    i++;
                }
            }
        }
        return factors;
    }

    public static Map<Integer, Integer> countItems(List<Integer> list) {
        Map<Integer, Integer> itemCount = new HashMap<>();
        for (int item : list) {
            if (itemCount.get(item) != null) {
                itemCount.put(item, itemCount.get(item) + 1);
            } else {
                itemCount.put(item, 1);
            }
        }
        return itemCount;
    }

    public boolean ispowerfulNumber(int number) {
        List<Integer> factors = primefactors(number);
        Map<Integer, Integer> factorsdict = countItems(factors);
        for (int i : factorsdict.values()) {
            if (i < 2) {
                return false;
            }
        }
        return true;
    }

    public void nthpowerPrime() {
        int num = sc.nextInt();
        int i = 0;
        int j = 1;
        while (i < num) {
            if (ispowerfulNumber(j)) {
                i++;
            }
            j++;
        }
        System.out.println(j - 1);
    }

    public boolean isHappyNumber(int number) {
        Set<Integer> seen = new HashSet<>();
        while (number != 1 && !seen.contains(number)) {
            seen.add(number);
            number = sumOfSquares(number);
        }
        return number == 1;
    }

    private int sumOfSquares(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    public void nthHappyNumber() {
        int n = sc.nextInt();
        int count = 0;
        int number = 1;
        while (count < n) {
            if (isHappyNumber(number)) {
                count++;
            }
            if (count < n) {
                number++;
            }
        }
        System.out.println(number);
    }
}








public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeekOneDayFive weekOneDayFive = new WeekOneDayFive(sc);

        
        weekOneDayFive.nthHappyNumber();

        sc.close();
    }
}






