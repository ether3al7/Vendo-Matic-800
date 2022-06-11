package com.techelevator.view;

public class Gum extends InventoryItem{
    public Gum(String slot, String name, Double price, String type, int currentStock) {
        super(slot, name, price, type, currentStock);
    }

    public Gum(String name, Double gumPrice) {
        super(name, gumPrice);
    }

    public String dispense(){
        return "Chew Chew, Yum!";
    }

}
