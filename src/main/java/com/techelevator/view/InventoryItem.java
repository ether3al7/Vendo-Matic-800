package com.techelevator.view;

public abstract class InventoryItem {
    private String slot;
    private String name;
    private Double price;
    private String type;
    private int currentStock;

    public InventoryItem(String slot, String name, Double price, String type, int currentStock){
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.currentStock = currentStock;
    }





}
