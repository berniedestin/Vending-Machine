package com.techelevator;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    private Map<String, Item> inventoryMap;

    public Map<String, Item> getInventoryMap() {
        return inventoryMap;
    }
    public List<String> getInventoryList(){
        List<String> inventoryList = new ArrayList<>();
        for (Map.Entry<String, Item> item : getInventoryMap().entrySet()) {
            inventoryList.add(item.getValue().getOutput());
        }
        Collections.sort(inventoryList);
        return inventoryList;
    }
    public void printInventoryList(){
        List<String> inventoryList = getInventoryList();
        for (String item : inventoryList) {
            System.out.println(item);
        }
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
