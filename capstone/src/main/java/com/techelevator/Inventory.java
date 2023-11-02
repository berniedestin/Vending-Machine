package com.techelevator;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private Map<String, Item> inventoryMap;

    public Map<String, Item> getInventoryMap() {
        return inventoryMap;
    }

    public Inventory(File stock) {
        this.inventoryMap = new HashMap<>();

        try (Scanner reader = new Scanner(stock)) {

            while(reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] lineArray = line.split("\\|");

                // flesh out this exception if input file does not follow parameters?
//                if (lineArray.length() > 4) {
//                    throw Exception;
//                }

                Item item = new Item(lineArray[0], lineArray[1], new BigDecimal(lineArray[2]), lineArray[3]);
                inventoryMap.put(lineArray[0], item);

            }
        } catch (Exception e) {
            System.out.println("Inventory file not found");
        }

    }

}
