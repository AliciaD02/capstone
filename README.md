# 💻 Accounting Ledger App

## 📌 Overview

This is a console-based Accounting Ledger application built in Java. It
allows users to track financial transactions such as deposits and
payments through an interactive menu system.

This project focuses on building a strong foundation in core programming
concepts including loops, methods, file handling, and object-oriented
programming.

------------------------------------------------------------------------

## 🚀 Features

-   Add Deposits (money coming in)
-   Add Payments (money going out)
-   View All Transactions
-   Filter by Deposits or Payments
-   Search by Vendor
-   Persistent storage using a CSV file

------------------------------------------------------------------------

## 🧠 How It Works

-   A `while` loop keeps the program running until the user exits
-   `Scanner` is used to handle user input
-   A `switch` statement manages menu navigation
-   Each feature is organized into its own method for clarity

------------------------------------------------------------------------

## 🧱 Object-Oriented Design

A `Transaction` class is used to represent each transaction with: -
Date - Time - Description - Vendor - Amount

------------------------------------------------------------------------

## 💾 File Handling

-   File name: `transactions.csv`
-   Format: `date|time|description|vendor|amount`
-   Uses:
    -   `FileWriter` for saving data
    -   `BufferedReader` for loading data

------------------------------------------------------------------------

## 📊 Menu Structure

### Main Menu

-   D → Deposit\
-   P → Payment\
-   L → Ledger\
-   X → Exit

### Ledger Menu

-   A → All Transactions\
-   D → Deposits Only\
-   P → Payments Only\
-   R → Reports\
-   H → Home

------------------------------------------------------------------------

## 📈 What I Learned

-   How to build a menu-driven application
-   How to work with files in Java
-   How to use classes and objects effectively
-   How to structure code using methods

------------------------------------------------------------------------

## ▶️ How to Run

1.  Open the project in IntelliJ
2.  Run `AccountingLedger.java`
3.  Follow the menu prompts in the console

------------------------------------------------------------------------

## 👩‍💻 Author

Alicia Diaz
