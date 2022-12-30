package app;
import java.util.Scanner;

public class PurchaseService {

    static String currency;
    static int quota;
    static double price;
    static double discount;
    static double amountDue;
    static double rawCost;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter amount of currency: ");
        currency = sc.nextLine();
        System.out.print("Enter amount of goods: ");
        quota = sc.nextInt();
        System.out.print("Enter price of goods: ");
        price = sc.nextDouble();
        sc.close();

        calculateAmountPay(quota, price);
        calculateAmountDue(rawCost);

        System.out.println("\nThanks for your purchase! " +
                "\n---------------------------\n" +
                "The cost of your goods is: " + currency + " " + rawCost +
                "\nYour discount is: " + currency + " " + rawCost * discount +
                "\nYour amount due is: " + currency + " " + amountDue);
    }

    private static double calculateAmountDue(double rawCost) {
        if (rawCost <= 5000) {
            discount = 0.05;
        } else if ((rawCost > 5000) && (rawCost <= 10000)) {
            discount = 0.1;
        } else if (rawCost > 10000) {
            discount = 0.15;
        }
        amountDue = rawCost - rawCost * discount;
        return amountDue;
    }

    private static double calculateAmountPay(int quota, double price) {
        rawCost = quota * price;
        return rawCost;
    }
}