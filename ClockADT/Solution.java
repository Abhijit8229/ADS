import java.util.Scanner;

class Clock {
    int hrs;
    int min;

    public Clock(int hrs, int min) {
        this.hrs = hrs;
        this.min = min;
        if (hrs < 0 || hrs > 23) {
            this.hrs = 0;
            this.min = 0;
        }

    }

    public Clock(String format) {
        String[] time = format.split(":");
        this.hrs = Integer.parseInt(time[0]);
        this.min = Integer.parseInt(time[1]);
        if (hrs < 0 || hrs > 23) {
            this.hrs = 0;
            this.min = 0;

        }
    }

    public void tic() {
        int totalMinutes = this.hrs * 60 + this.min + 1;
        this.hrs = (totalMinutes / 60) % 24;
        this.min = totalMinutes % 60;

    }

    public void toc(int min) {
        int totalMinutes = this.hrs * 60 + this.min + min;
        this.hrs = (totalMinutes / 60) % 24;
        this.min = totalMinutes % 60;
    }

    public boolean isEarlierThan(Clock other) {
        if (this.hrs < other.hrs) {
            return true;
        }
        if (this.hrs == other.hrs && this.min < other.min) {
            return true;
        }
        return false;
    }

    public String toString() {

        return String.format("%02d:%02d", hrs, min);

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int test = Integer.parseInt(sc.nextLine());

        while (test-- > 0) {
            switch (line) {
                case "constructor(int, int)":
                    String[] input1 = sc.nextLine().split(",");
                    System.out.println(new Clock(Integer.parseInt(input1[0]), Integer.parseInt(input1[1])));
                    break;

                case "constructor(String)":
                    System.out.println(new Clock(sc.nextLine()));
                    break;

                case "tic()":
                    Clock clockTic = new Clock(sc.nextLine());
                    clockTic.tic();
                    System.out.println(clockTic);
                    break;

                case "toc(int)":
                    String[] input2 = sc.nextLine().split(",");
                    Clock clockToc = new Clock(input2[0]);
                    clockToc.toc(Integer.parseInt(input2[1]));
                    System.out.println(clockToc);
                    break;

                case "isEarlierThan(Clock)":
                    String[] input3 = sc.nextLine().split(",");
                    System.out.println(new Clock(input3[0]).isEarlierThan(new Clock(input3[1])));
                    break;

                case "toString()":
                    System.out.println("null");
                    break;
            }
        }
        sc.close();
    }
}
