package danilofreitas.bank;

import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank danBank = new Bank("0001");

        // C = Create account
        // E = Exit
        while (true) {
            System.out.println("What do you do? \n C = Create Account  \n E = Exit ");
            String op = scanner.nextLine();


            if (op.equals("C")) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                Account account = danBank.generateAccount(name);
                danBank.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again!");
            }
        }

        List<Account> accountList = danBank.getAccounts();
        for( Account cc: accountList){
            System.out.println(cc);
        }

        danBank.outputTotal();
    }

        static void operateAccount(Account account){
            Scanner scanner = new Scanner(System.in);
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


