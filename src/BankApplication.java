import java.util.Scanner;

class BankAccount {
    private final String accountNumber = "1234567890";
    private final String PIN = "1234";
    private double balance = 100000;
    private int credit = 10000000;

    public boolean verification(String accNum, String pin) {

        return accNum.equals(accountNumber) && pin.equals(PIN);
    }

    public double getBalance() {

        return balance;
    }

    public int getCredit() {

        return credit;
    }

    public void setBalance(double newBalance) {

        balance = newBalance;
    }

    public void setCredit(int newCredit) {

        credit = newCredit;
    }
}

class BankSystem {
    public static void withdrawal(BankAccount account, double amount) {
        if (amount > account.getBalance() || account.getBalance() - amount < 50000) {
            System.out.println("Withdrawal failed. Insufficient balance or minimum balance requirement not met.");
        } else {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            System.out.println("Withdrawal successful! New balance: " + newBalance);
        }
    }

    public static void deposit(BankAccount account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println("Deposit successful! New balance: " + newBalance);
        }
    }

    public static void convertCreditToCash(BankAccount account, int creditToConvert) {
        if (creditToConvert <= 0 || creditToConvert > account.getCredit()) {
            System.out.println("Invalid credit amount or insufficient credit.");
        } else {
            int convertedAmount = creditToConvert * 1000;
            double newBalance = account.getBalance() + convertedAmount;
            int newCredit = account.getCredit() - creditToConvert;
            account.setBalance(newBalance);
            account.setCredit(newCredit);
            System.out.println("Credit conversion successful! New balance: " + newBalance + ", New credit: " + newCredit);
        }
    }
}

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("==================================");
        System.out.println("WELCOME TO SIMPLE BANKING APP!");
        System.out.println("==================================");
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (account.verification(accNum, pin)) {
            System.out.println("Verification successful.");
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Credit: " + account.getCredit());

            System.out.println("==================================");
            System.out.println("\nChoose an option:");
            System.out.println("==================================");
            System.out.println("a. Withdrawal");
            System.out.println("b. Deposit");
            System.out.println("c. Convert credit to cash");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "a":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    BankSystem.withdrawal(account, withdrawalAmount);
                    break;
                case "b":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    BankSystem.deposit(account, depositAmount);
                    break;
                case "c":
                    System.out.print("Enter credit amount to convert: ");
                    int creditToConvert = scanner.nextInt();
                    BankSystem.convertCreditToCash(account, creditToConvert);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Error: Verification failed.");
        }
        scanner.close();
    }
}
