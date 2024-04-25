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

        // Meminta pengguna memasukkan jumlah uang dalam IDR
        System.out.print("Input Amount in IDR: ");
        double jumlah = scanner.nextDouble();

        //objek
        CurrencyConverter converter = new CurrencyConverter(jumlah);

        System.out.println("Choose the conversion currency:");
        System.out.println("a. USD");
        System.out.println("b. SGD");
        System.out.println("c. JPY");

        System.out.print("Choice: ");
        char choice = scanner.next();
        switch (choice.toLowerCase()) {
            case "a":
                System.out.println("Conversion result to USD: " + converter.USD() + " USD");
                break;
            case "b":
                System.out.println("Conversion result to SGD: " + converter.SGD() + " SGD");
                break;
            case "c":
                System.out.println("Conversion result to JPY: " + converter.JYP() + " JPY");
                break;
            default:
                System.out.println("Invalid!");
        }

        scanner.close();

    }
}
