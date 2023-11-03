package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slot;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;


    public Item(String slot, String name, BigDecimal price, String type) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }


    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMessage() {

        String message = "";

        if (type.equals("Chip")) {
            message = "Crunch Crunch, Yum!";
        }
        if (type.equals("Candy")) {
            message = "Munch Munch, Yum!";
        }
        if (type.equals("Drink")) {
            message = "Glug Glug, Yum!";
        }
        if (type.equals("Gum")) {
            message =  "Chew Chew, Yum!";
        }

        return message;
    }

    public String getOutput() {

        String quantityValue = "QTY: ";
        if (quantity == 0) {
            quantityValue += "SOLD OUT";
        } else {
            quantityValue += Integer.toString(quantity);
        }

        return getSpaces(2) + slot + getSpaces(5 - slot.length()) +
                name + getSpaces(22 - name.length()) +
                price + getSpaces(10 - price.toString().length()) +
                type + getSpaces(10 - type.length()) +
                quantityValue + getSpaces(15 - quantityValue.length());

    }

    public String getSpaces(int space){
        String spaces = "";
        if(space > 0) {
            for (int i = 1; i <= space; i++) {
                spaces += " ";
            }
        }
        return spaces;
    }
}
