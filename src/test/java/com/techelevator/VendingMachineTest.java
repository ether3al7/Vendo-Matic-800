package com.techelevator;

import com.techelevator.view.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {


    //Create Vending Machine Test
    @Test
    public void Create_Vending_Machine_Test(){
        VendingMachine sut = new VendingMachine();
        sut.createVendingMachine();

        int mapSize = sut.getVendingMachineStock().size();

        Assert.assertEquals(16, mapSize);

    }


    //Display Vending Machine Tests
    @Test
    public void Display_Vending_Machine_Test(){

    }

    @Test
    public void Vending_Machine_Sold_Out_Test(){}


    //Select Product Tests
    @Test
    public void Select_Product_Test() {
        VendingMachine sut = new VendingMachine();
        sut.createVendingMachine();
        double price = sut.selectProduct("D1");
        Assert.assertEquals(0.85, price, .00);
    }


    @Test
    public void Select_Non_Existent_Product_Test(){}

    @Test
    public void Select_Sold_Out_Product_Test(){}

    @Test
    public void Insufficient_Funds_Test(){}


    //Feed Money Tests
    @Test
    public void Feed_Money_Test(){}

    @Test
    public void Feed_Invalid_Input_Test(){}


    //Give Change Test
    @Test
    public void Give_Change_Test(){}
}
