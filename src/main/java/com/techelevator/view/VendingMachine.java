package com.techelevator.view;

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
        for (Map.Entry<String, InventoryItem> m : vendingMachineStock.entrySet()){
            System.out.println(m.getKey() + "|" +  m.getValue().getName() + "|" +  m.getValue().getPrice() + "|Stock: " + m.getValue().getCurrentStock());
        }
    }

    public void selectProduct(String productCode) {


            if (!(vendingMachineStock.containsKey(productCode))) {
                System.out.println("Not a valid entry");

            } if (vendingMachineStock.containsKey(productCode) && amount >= vendingMachineStock.get(productCode).getPrice()) {
                amount -= vendingMachineStock.get(productCode).getPrice();
                vendingMachineStock.get(productCode).decreaseCurrentStock();
                System.out.println(vendingMachineStock.get(productCode).dispense());
                //   System.out.println(vendingMachineStock.get(productCode).getCurrentStock());
            } else if (!(amount >= vendingMachineStock.get(productCode).getPrice())) {
                System.out.println("Not enough money");
            }


        System.out.println("Amount Remaining: " + amount);
    }

    public void feedMoney(Double amountEntered){

        this.amount += amountEntered;
        System.out.println("Amount Remaining: " + amount);

    }

    public void giveChange(){
       // working on this

    }



}
