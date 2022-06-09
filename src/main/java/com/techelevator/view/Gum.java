package com.techelevator.view;

public class Gum extends InventoryItem{
    public Gum(String slot, String name, Double price, String type, int currentStock) {
        super(slot, name, price, type, currentStock);
    }
    public String dispense(){
        return "Chew Chew, Yum!";
    }
}
