package com.techelevator.view;

public class Drink extends InventoryItem{
    public Drink(String slot, String name, Double price, String type, int currentStock) {
        super(slot, name, price, type, currentStock);
    }
    public String dispense(){
        return "Glug Glug, Yum!";
    }
}
