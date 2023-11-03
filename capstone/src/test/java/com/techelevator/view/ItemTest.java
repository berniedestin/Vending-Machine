package com.techelevator.view;

import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {
    @Test
    public void test_getMessage_Chip(){
        Item item = new Item("A1", "Potato Crisps", new BigDecimal("3.05"), "Chip");

        String result = item.getMessage();

        Assert.assertEquals("Crunch Crunch, Yum!", result);
    }
    @Test
    public void test_getOutput_qty_0(){
        Item item = new Item("A1", "Potato Crisps", new BigDecimal("3.05"), "Chip");
        item.setQuantity(0);
        String result = item.getOutput();

        Assert.assertEquals("  A1   Potato Crisps         3.05      Chip      QTY: SOLD OUT  ", result);
    }
}
