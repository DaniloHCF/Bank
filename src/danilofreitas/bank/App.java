package danilofreitas.bank;

import java.util.Scanner;
import java.util.WeakHashMap;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account = new Account("0001", "1234-1", "Albert");

        // D - Deposit
        // W - Withdraw
        // E - Exit
        while (true) {
            System.out.println("Please tell us what you want to do? \n D = Deposit \n W = Withdraw \n E = Exit ");
            String op = scanner.nextLine();

            if (op.equals("D")){
                System.out.println("How much do you wish to deposit? ");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("W")) {
                System.out.println("How much would you like to withdraw?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)){
                    System.out.println("Unfortunately it is impossible to withdraw $ "+ value);
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again!");
            }

            scanner = new Scanner(System.in);
        }

    }

}
