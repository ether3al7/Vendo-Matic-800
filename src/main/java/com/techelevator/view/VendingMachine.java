package com.techelevator.view;

import com.techelevator.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {

    private Map<String, InventoryItem>vendingMachineStock = new TreeMap<>(); // <-- TreeMap sorts key by ascending order
    // hashmaps are unordered, when printed keys rows will be randomized
    private Double amount = 0.00; // storing money user inputs

    public void createVendingMachine(){
        //created map to store .csv file, looping thru to get text
        //stored abstract class InventoryItem as value for map
        String line = "";
        String csvFile = "capstone-1/vendingmachine.csv";
        try {
            File file = new File(csvFile);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){

                 line = sc.nextLine();
                 String[]products = line.split("\\|");

                 //A1|Potato Crisps|3.05|Chip
                // 0        1        2    3

                if (products[3].equals("Chip")) {   // <-- if index 3 of split string = Chip
                    Double chipPrice = Double.parseDouble(products[2]); // <-- parsing string index 2 to double, this will be passed thru constructor
                    Chip chip = new Chip(products[1], chipPrice);   // <--creating instance of chip, which takes in a String name and double
                    vendingMachineStock.put(products[0], chip);   // <-- adding product code as String key, adding chip as inventoryItem value for map

                } else if (products[3].equals("Drink")) {
                    Double drinkPrice = Double.parseDouble(products[2]); // same as above except for Drink
                    Drink drink = new Drink(products[1], drinkPrice);
                    vendingMachineStock.put(products[0], drink);

                } else if (products[3].equals("Candy")) {
                    Double candyPrice = Double.parseDouble(products[2]);
                    Candy candy = new Candy(products[1], candyPrice);
                    vendingMachineStock.put(products[0], candy);

                } else if (products[3].equals("Gum")) {
                    Double gumPrice = Double.parseDouble(products[2]);
                    Gum gum = new Gum(products[1], gumPrice);
                    vendingMachineStock.put(products[0], gum);
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayVendingMachine(){
        //looping thru using getters in sub classes to print values
        for (Map.Entry<String, InventoryItem> m : vendingMachineStock.entrySet()) {
            if (m.getValue().getCurrentStock() == 0) { //<-- if sold out
                System.out.println(m.getKey() + "|" + m.getValue().getName() + "|" + m.getValue().getPrice() + "|Sold Out! "); // added line for if sold out
            } else {
                System.out.println(m.getKey() + "|" + m.getValue().getName() + "|" + m.getValue().getPrice() + "|Stock: " + m.getValue().getCurrentStock());
            }
        }
    }

    public void selectProduct(String productCode) {
         Log log = new Log();

            if (!(vendingMachineStock.containsKey(productCode))) {
                System.out.println("Not a valid entry");

            } else if (vendingMachineStock.containsKey(productCode)) {

                if (vendingMachineStock.get(productCode).getCurrentStock() > 0) { // <-- if product is in stock

                    if (amount >= vendingMachineStock.get(productCode).getPrice()) { //<-- if can afford item

                        amount -= vendingMachineStock.get(productCode).getPrice(); //<-- updating amount variable
                        vendingMachineStock.get(productCode).decreaseCurrentStock(); //<-- decreasing stock in map by 1
                        System.out.println(vendingMachineStock.get(productCode).dispense()); //<-- printing String message
                        String productName = vendingMachineStock.get(productCode).getName(); //<-- getting name for parameter
                        log.log(productName, productCode); //<-- logs using productName and productCode

                    } else if (!(amount >= vendingMachineStock.get(productCode).getPrice())) {
                        System.out.println("Not enough money");
                    }
                } else {   //<-- currentStock = 0
                    System.out.println("Sold Out!");
                }
            }

        System.out.println("Amount Remaining: " + Math.round((amount) * 100.00) / 100.00); //<-- using math.round to round 2 decimal places

    }

    public void feedMoney(Double amountEntered){
        Log log = new Log();

        this.amount += amountEntered;
        System.out.println("Amount Remaining: " + amount);
        log.log("FEED MONEY: ");

    }

    public void giveChange(){
        //The customer's money is returned using nickels, dimes, and quarters (using the smallest amount of coins possible).
        //The machine's current balance must be updated to $0 remaining.
        //After completing their purchase, the user is returned to the "Main" menu to continue using the vending machine.
       // DecimalFormat amountWithTwoDecimals = new DecimalFormat("0.00"); //<-- limiting amount to only two decimal places
        Log log = new Log();
        double quarter = 0.25;
        int quartersReturned = 0;
        double dime = 0.10;
        int dimesReturned = 0;
        double nickel = 0.05;
        int nickelsReturned = 0;
        //.85   1.75   2.25   2.85
       // working on this
          while ( amount > 0.00) {

              if (amount >= quarter) {
                  amount = Math.round((amount - quarter) * 100.00)/100.00;
                  quartersReturned++;

              } else if (amount >= dime) {
                  amount = Math.round((amount - dime) * 100.00)/100.00;
                  dimesReturned++;

              } else if (amount >= nickel) {
                  amount = Math.round((amount - nickel) * 100.00)/100.00;
                  nickelsReturned++;
              }
          }

        System.out.println("Your change is: " + quartersReturned + " Quarters, " + dimesReturned + " Dimes, " + nickelsReturned + " Nickels.");
          log.log("GIVE CHANGE: ");


    }
}
