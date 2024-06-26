import java.util.InputMismatchException;
import java.util.Scanner;

class CurrencyConverter {
    private double jumlah;

    // Constructor
    public CurrencyConverter(double jumlah) {
        this.jumlah = jumlah;
    }

    // Get Method untuk mengambil nilai inputan user
    public double getAmount() {
        return jumlah;
    }

    // IDR-USD
    public double USD() {
        return jumlah / 16.172;
    }

    // IDR-SGD
    public double SGD() {
        return jumlah / 11.889;
    }

    // IDR-JYP
    public double JYP() {
        return jumlah / 103;
    }
}

public class MoneyConverter {
    public static void main(String[] args) {
        System.out.println("WELCOME TO CURRENCY CONVERSION APP!");
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta pengguna memasukkan jumlah uang dalam IDR
            System.out.print("Input Amount in IDR: ");
            double jumlah = scanner.nextDouble();

            // Validasi input untuk memastikan jumlah yang dimasukkan adalah angka positif
            if (jumlah <= 0) {
                throw new IllegalArgumentException("Amount must be a positive number.");
            }

            //objek
            CurrencyConverter converter = new CurrencyConverter(jumlah);

            System.out.println("Choose the conversion currency:");
            System.out.println("a. USD");
            System.out.println("b. SGD");
            System.out.println("c. JPY");

            System.out.print("Choice: ");
            String choice = scanner.next();
            switch (choice.toLowerCase()) {
                case "a":
                    System.out.printf("Conversion result to USD: %.2f USD\n", converter.USD());
                    break;
                case "b":
                    System.out.printf("Conversion result to SGD: %.2f SGD\n", converter.SGD());
                    break;
                case "c":
                    System.out.printf("Conversion result to JPY: %.2f JPY\n", converter.JYP());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
