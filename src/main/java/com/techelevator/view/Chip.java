package com.techelevator.view;

public class Chip extends InventoryItem{

    public Chip(String slot, String name, Double price, String type, int currentStock) {
        super(slot, name, price, type, currentStock);

        }

    public String dispense(){

        return "Crunch Crunch, Yum";

    }
}
