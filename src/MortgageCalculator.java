import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner userScanner = new Scanner(System.in);

        System.out.print("Principle ($1k - $1M): ");
        int principle = userScanner.nextInt();
        while (!(principle >= 1000) || !(principle <= 1_000_000)) {
             System.out.println("Please enter a number between $1,000 - $1,000,000.");
            System.out.print("Principle ($1k - $1M): ");
            principle = userScanner.nextInt();
        } // end while

        System.out.print("Annual Interest Rate: ");
        float enteredRate = userScanner.nextFloat();
        float monthlyRate = (enteredRate / PERCENT) / MONTHS_IN_YEAR;
        while (enteredRate <= 0 || enteredRate > 30) {
            System.out.println("Please enter a rate greater than 0 or less than or equal to 30.");
            System.out.print("Annual Interest Rate: ");
            enteredRate = userScanner.nextFloat();
        }// end while

        System.out.print("Period (Years): ");
        int yearsEntered = userScanner.nextInt();
        int numberOfPayments = yearsEntered * MONTHS_IN_YEAR;
        while (yearsEntered < 1 || yearsEntered > 30){
            System.out.println("Please enter a number of years between 1 and 30.");
            System.out.print("Period (Years): ");
            yearsEntered = userScanner.nextInt();
        }

        float monthlyPayment = (float) (principle * (
                (monthlyRate * Math.pow((1 + monthlyRate), numberOfPayments))
                / (Math.pow((1 + monthlyRate), numberOfPayments) - 1)
        )
        );

        NumberFormat changeToCurrency = NumberFormat.getCurrencyInstance();
        System.out.print(changeToCurrency.format(monthlyPayment));
    }


}
