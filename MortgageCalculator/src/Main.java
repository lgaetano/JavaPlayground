import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        /* Mortgage Calculator
         * Principal (p): amount of loan
         * Monthly Interest Rate (r): Annual interest rate / 1200
         * Number of Payments (n): period * 12
         *
         * Equation: P * ((r(1 + r)^n)/((1 + r)^n - 1)
         * */
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Retrieve input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        // Calculate
        double mortgage = principal
                * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));


        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.print("Mortgage: " + mortgageFormatted);
    }
}