package com.techelevator.view;

public class Candy extends InventoryItem{
    public Candy(String slot, String name, Double price, String type, int currentStock) {
        super(slot, name, price, type, currentStock);
    }

    public Candy(String name, Double candyPrice) {
        super(name,candyPrice);
    }

    public String dispense(){

        return "Munch Munch, Yum!";

    }
    
}
