package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class AccountingLedger {//the class start here

    // so the scanner is accessible throughout the program
    static Scanner theScanner = new Scanner(System.in);
    static ArrayList<Transaction> transactionList = new ArrayList<>();


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
                    *************************
                    FINANCIAL TRANSACTIONS
                    *************************
                    Make your selection:
                    D) Deposit:
                    P) Payment:
                    L) Ledger:
                    X) Exit:
                    *************************
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
                    ledger();
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


        System.out.println("Deposit added: ");

        saveTransaction(description, vendor, amount);

    }

    public static void payment() {     // we need to create a method for the payment

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
            // .csv is a file the program creates to store data  . csv = Comma Separated Values
            // you need to get the date = time
            //used a FileWriter to open file, i set it to true so it adds data instead of overwriting it (t append mode)
            FileWriter file = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter writer = new BufferedWriter(file);

             // wanted this formatter
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            //used so each transaction saves current d/t
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(dateFormatter);
            String time = now.format(timeFormatter);


            // LocalTime time = LocalTime.now();   - changed it to one
            // created Transaction to store all data (o)
            Transaction theTransaction = new Transaction(date, time, description, vendor, amount);

            //writing the transaction into the file
            writer.write(theTransaction.toString());       //important! need toString to convert (o)
            writer.close(); //used close so data is saved
            file.close();
            //so new updates my program
            loadTransaction();

        } catch (Exception e) {

            System.out.println(" Error saving transaction. ");
        }

    }


    public static void loadTransaction() {      // this method is used when the user selects L = Ledger
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");




                String date = parts[0];
                String time = parts[1];
                String description = parts[2];
                String vendor = parts[3];
                String amount = parts[4];

                Transaction theTransaction = new Transaction(date, time, description, vendor, Double.parseDouble(amount));
                transactionList.add(theTransaction);

            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading ledger:" + e.getMessage());


        }

    }

    public static void ledger() {

        boolean running = true;


        // I am creating a while loop
        while (running) {

            //Display the menu

            System.out.println("""
                    **********************************
                    Make your selection:
                    A) All:
                    D) Deposits:
                    P) Payment:
                    R) Report:
                    H) Home:
                    **********************************
                    """);

            // we need to get users input and store it as a choice
            String choice = theScanner.nextLine();

            // after getting the input of the user you have to decide what to do with it


            // be using a switch tool so it can be easier to read rather than an if statement
            switch (choice.toUpperCase()) {   //  if user wants to type lowercase you need to add.toLowerCase otherwise default

                case "A":
                    displayAll();
                    break;
                case "D":
                    displayDeposit();
                    break;
                case "P":
                    displayPayment();
                    break;
                case "R":
                    Reports();
                    break;
                case "H":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection please try again");
                    // input in only needed when you are creating a data.

            }


        }


    }

    public static void displayAll() {    // create method for display all
          // for-each loop to go through every transaction list
        for (Transaction transaction : transactionList) {
            System.out.print(transaction.toString());


        }


    }

    public static void displayDeposit() {    // method for deposit
           // did the same thing on displayAll method
        for (Transaction transaction : transactionList) {

            if (transaction.getAmount() > 0) {
                System.out.print(transaction.toString());
            }

        }

    }

    public static void displayPayment() {          // method for payment

        for (Transaction transaction : transactionList) {

            if (transaction.getAmount() < 0) {
                System.out.print(transaction.toString());
            }


        }


    }

    public static void Reports() {    // method for reports
        boolean running = true;

        while (running) {

            // created a menu for report so user is able to run reports/run customer search
            System.out.println("""
                    ******************************
                    Reports Menu:
                    1) Month To Date
                    2) Previous Month
                    3) Year To Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Back
                    ******************************
                    """);


              // created a switch method
            String choice = theScanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Month to Date selected");
                    break;

                case "2":
                    System.out.println("Previous Month selected");
                    break;

                case "3":
                    System.out.println("Year To Date selected");
                    break;
                case "4":
                    System.out.println("Previous Year selected");
                    break;
                case "5":
                    searchByVendor();      // the prompt goes inside the method
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    
                    

            }


        }
    }

    public static void searchByVendor(){   // starts the method
        System.out.println("Enter vendor name:");
        String search = theScanner.nextLine().toLowerCase();  // this reads the  input

        for(Transaction transaction: transactionList) {

            if(transaction.getVendor().toLowerCase().contains(search)){
                System.out.println(transaction.toString());
            }

        }
    }

}
    
