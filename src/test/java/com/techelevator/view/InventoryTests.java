package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTests {

    @Test
    public void Test_Candy() {

        Candy candy = new Candy("Crunchie",  1.75 );

        Assert.assertEquals("Crunchie", candy.getName());
        Assert.assertEquals("Munch Munch, Yum!", candy.dispense());
    }

    @Test
    public void Test_Chip() {
        Chip chip = new Chip("Potato Crisps",  3.05 );

        Assert.assertEquals("Potato Crisps", chip.getName());
        Assert.assertEquals("Crunch Crunch, Yum!", chip.dispense());
    }

    @Test
    public void Test_Drink() {
        Drink drink = new Drink("Mountain Melter",  1.50 );

        Assert.assertEquals("Mountain Melter", drink.getName());
        Assert.assertEquals("Glug Glug, Yum!", drink.dispense());
    }

    @Test
    public void Test_Gum() {
        Gum gum = new Gum("Chiclets",  0.75 );

        Assert.assertEquals("Chiclets", gum.getName());
        Assert.assertEquals("Chew Chew, Yum!", gum.dispense());
    }
}