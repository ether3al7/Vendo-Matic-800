package com.techelevator.view;

import java.util.Scanner;

public class Purchase {

    private double amount;



    public void selectProduct(){

    }


    public void feedMoney(){
        //Selecting "(1) Feed Money" allows the customer to repeatedly
        // feed money into the machine in valid, whole dollar amounts—for example, $1, $2, $5, or $10.
        System.out.println("Please enter an amount");

        Scanner sc = new Scanner(System.in);
        double amountEntered = sc.nextDouble();

        if (amountEntered == 1 || amountEntered == 2 || amountEntered == 5 || amountEntered == 10){

            this.amount = amountEntered;

        }else{
            System.out.println("Not a valid whole dollar amount");
        }
        System.out.println(" Current Money Provided: " + amount);
    }

     public void printPurchaseMenu(){
        System.out.println("" +
                "(1) Feed Money\n" +
                "(2) Select Product\n" +
                "(3) Finish Transaction");


    }

    public double getAmount() {
        return amount;
    }


}
