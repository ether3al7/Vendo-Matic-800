package com.techelevator;


import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class VendingMachineTest {

    //The file found in main is in a different format from the one found in test
    //below is the one found in my computer
    File file = new File("vendingmachine.csv");//<-- found in tests using this format


    //Create Vending Machine Test
    @Test
    public void Create_Vending_Machine_Test(){
            VendingMachine sut = new VendingMachine();
            sut.createVendingMachine(file);
            int mapSize = sut.getVendingMachineStock().size();
            Assert.assertEquals(16, mapSize);
    }

    @Test
    public void Display_Vending_Machine_Test(){
        VendingMachine sut = new VendingMachine();
        sut.createVendingMachine(file);
    }

    @Test
    public void Vending_Machine_Sold_Out_Test(){}


    @Test
    public void Select_Product_Test() {
        VendingMachine sut = new VendingMachine();
        sut.createVendingMachine(file);
     //   sut.feedMoney(5.0);
//        double price = sut.selectProduct("D1");
//        Assert.assertEquals(0.85, price, .00);
    }


    @Test
    public void Select_Non_Existent_Product_Test(){
        VendingMachine sut = new VendingMachine();
        sut.createVendingMachine(file);
      //  sut.selectProduct("non-existent");

    }

    @Test
    public void Select_Sold_Out_Product_Test(){}

    @Test
    public void Insufficient_Funds_Test(){}

    @Test
    public void Feed_Money_Test(){}

    @Test
    public void Feed_Invalid_Input_Test(){}

    @Test
    public void Give_Change_Test(){}
}
