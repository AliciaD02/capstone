package com.pluralsight;

import java.util.Scanner;

public class AccountingLedger {
    // so the scanner is accessible throughout the program
    static Scanner theScanner = new Scanner(System.in);

    // you need a main method to start the class

    public static void main(String[] args) {

        // I am building a banking app
        /* Create a menu
        D-deposit
        P-payment
        L-Ledger
        X-Exit
         */

        // I used a boolean to determine if the app stops or not
        boolean running = true;


        // I am creating a while loop
        while (running) {


            System.out.println("""
                    Make your selection:
                    D) Deposit:
                    P) Payment:
                    L) Ledger:
                    X) Exit:
                    """);

            // we need to get users input and store it as a choice

            String choice = theScanner.nextLine();

            // after getting the input of the user you have to decide what to do with it
            // this is where you make the if statement because there is multiple selections

            // be using a switch tool so it can be easier to read rather than an if statement


            switch (choice.toUpperCase()) {   //  if user wants to type lowercase or uppercase you need to add.toLowerCase

                case "D":
                    Deposit();
                    break;
                case "P":
                    Payment();
                    break;
                case "L":
                    Ledger();
                    break;
                case "X":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection please try again");

            }


        }


    }
   // in order for each selection to be stored you need to add a method.

    public static void Deposit() {
        // after creating the methods we need to ask the user info
        System.out.println("Enter description:");
        String description = theScanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = theScanner.nextLine();

        System.out.println("Enter amount: ");
        String amount = theScanner.nextLine();
        //?
        theScanner.nextLine();

        System.out.println("Deposit added: ");


    }

     public static void Payment() {
        System.out.println("Payment selected");
        String selected = theScanner.nextLine();

        System.out.println("Enter description: ");
        String description = theScanner.nextLine();

         System.out.println("Enter vendor: ");
        String vendor = theScanner.nextLine();


         System.out.println("Enter amount: ");
        String amount = theScanner.nextLine();

    }

   // public static void Ledger() {
      //  System.out.println("Ledger selected");
    }

}