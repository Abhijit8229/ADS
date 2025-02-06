import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class transaction {
    String type;
    double amount;

    public transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public transaction() {
        this.type = "-";
        this.amount = 0.0;
    }

    @Override
    public String toString() {
        return type + amount;
    }

}

class DigitalWallet {
    double balance;
    List<transaction> transactionList = new ArrayList<transaction>();
    private Scanner sc;

    public DigitalWallet(Scanner sc) {
        this.sc = sc;
    }

    public void initializeWallet() {
        balance = 0.0;
        System.out.println("Wallet initialized with balance 0 and empty transaction history.");
    }

    public void addMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Transaction not recorded.");
            return;
            
        }
        balance += amount;
        transactionList.add(new transaction("+", amount));
        System.out.printf("Balance updated to %.1f, transaction history logged.\n", balance);
    }

    public void payMoney(double amount) {
        if (balance<amount) {
            System.out.println("Insufficient balance. Transaction not recorded.");
            if (!transactionList.isEmpty()) {
                transactionList.remove(transactionList.size() - 1); 
            }
            return;
            
        }
        balance -= amount;
        transactionList.add(new transaction("-", amount));
        System.out.printf("Balance updated to %.1f, transaction history logged.\n", balance);
    }

    public void showTransaction() {
        System.out.println(transactionList.toString());
    }

    public void showBalance() {
        System.out.println("Current balance: "+balance);
    }

    public void FormatInput() {

        String next = "";
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] op = line.split(":");

            if (op[0].equals("Method")) {

                if (op[1].trim().equals("initialize_wallet")) {
                    initializeWallet();
                } else if (op[1].trim().equals("add_funds")) {
                    next = "add_funds";
                } else if (op[1].trim().equals("make_payment")) {
                    next = "make_payment";
                }

                else if (op[1].trim().equals("view_transaction_history")) {
                    showTransaction();
                } else if (op[1].trim().equals("display_balance")) {
                    showBalance();
                }
            } else if (op[0].equals("Inputs")) {
                if (next.equals("add_funds")) {
                    addMoney(Double.parseDouble(op[1].trim().split("=")[1].trim()));
                    next = "";
                } else if (next.equals("make_payment")) {
                    payMoney(Double.parseDouble(op[1].trim().split("=")[1].trim()));
                    next = "";
                }

            }
        }

    }

}

public class Solution {
    public static void main(String[] args) {
        DigitalWallet dw = new DigitalWallet(new Scanner(System.in));
        dw.FormatInput();
    }
}
