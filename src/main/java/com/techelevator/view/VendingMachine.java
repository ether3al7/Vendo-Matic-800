package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

   // private String "A1|Potato Crisps|3.05|Chip" = 5

    public void displayVendingMachine(){

        String line = "";
        String csvFile = "capstone-1/vendingmachine.csv";
        List <Object>vendingMachineProducts = new ArrayList<>();

        try {
            File file = new File(csvFile);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){

                line += sc.nextLine();
                line += "| 5 \n";

            }
                String[]products = line.split("\\|");

               for(String s : products){
                   vendingMachineProducts.add(s);
               }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.print(line);

      //  System.out.println(vendingMachineProducts.toString());
    }





}
