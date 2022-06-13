package com.techelevator.view;

public abstract class InventoryItem {
    private String slot;
    private String name;
    private Double price;
    private String type;
    private int currentStock = 5; // <--added stock as 5 for all classes that extends... still working on this

    //added method to decrement currentStock at the bottom
    //also created 2 argument constructors for classes that extend, saves code...for now


    public InventoryItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    //abstract method
    public abstract String dispense();

    public void decreaseCurrentStock(){
        currentStock--;
    }

}
