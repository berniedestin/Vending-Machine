package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InventoryTest {



    @Test
    public void test_map_one() {

        // this test fails for unknown reason, values verified to be apparently equal while debugging

        File test = new File("src/test/resources/test.csv");
        Inventory testInventory = new Inventory(test);

        Map<String, Item> expectedMap = new HashMap();

        expectedMap.put("A1", new Item("A1", "Potato Crisps", new BigDecimal("3.05"), "Chip"));

        Assert.assertEquals(testInventory.getInventoryMap(), expectedMap);


    }



}
