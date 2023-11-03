package com.techelevator;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String RESET = "\033[0m";  // Text Reset
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
        boolean isLight = true;
        for (String item : inventoryList) {
            if(isLight){
                System.out.println( WHITE_BACKGROUND_BRIGHT + BLACK_BOLD + item + RESET);
            } else {
                System.out.println(BLACK_BOLD + WHITE_BACKGROUND + item + RESET);
            }
            isLight = !isLight;
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
