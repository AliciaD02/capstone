package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;

public class AccountingLedger {//the class start here

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

            //Display the menu

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


            switch (choice.toUpperCase()) {   //  if user wants to type lowercase you need to add.toLowerCase otherwise default

                case "D":
                    deposit();
                    break;
                case "P":
                    payment();
                    break;
                case "L":
                    Ledger();
                    break;
                case "X":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection please try again");
                    // input in only needed when you are creating a data.

            }

        }

    }

    // in order for each selection to be stored you need to add a method but outside the other method
    // main is one function and deposit, etc. is another function
    public static void deposit() {
        // after creating the methods we need to ask the user info

        System.out.println("Enter description:");
        String description = theScanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = theScanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(theScanner.nextLine());
        //?

        System.out.println("Deposit added: ");

        saveTransaction(description, vendor, amount);

    }

    public static void payment() {     // this method means when the user selects P = Payment.

        System.out.println("Enter description: ");
        String description = theScanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = theScanner.nextLine();


        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(theScanner.nextLine());
        amount = amount * -1;      // you have to make it negative because payment = money going out

        saveTransaction(description, vendor, amount);

        System.out.println("Payment added. ");


    }

    // we use saveTransaction for saving the data
    public static void saveTransaction(String description, String vendor, double amount) {
        System.out.println("Saving transaction...");


        System.out.println(description + " | " + vendor + " | " + amount);
        // we use the FileWriter to write through here to the file

        //The file is open
        try {
            FileWriter file = new FileWriter("src/main/resources/transactions.csv", true);

            BufferedWriter writer = new BufferedWriter(file);
            writer.write(description + " | " + vendor + " | " + amount + "\n");
            writer.close();
            file.close();


        } catch (Exception e) {

            System.out.println(" Error saving transaction. ");

        }   // .csv is a file the program creates to store data  . csv = Comma Separated Values
        // you need to get the date = time


    }


    public static void Ledger() {      // this method is used when the user selects L = Ledger
        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                String date = parts[0];
                String time = parts[1];
                String description = parts[2];
                String vendor = parts[3];
                String amount = parts[4];

                System.out.println(date + "|" + time + " | " + description + " | " + vendor + " | " + amount);

            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading ledger:" + e.getMessage());


        }

    }


}






