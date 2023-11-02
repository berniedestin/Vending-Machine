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

        return slot + " " + name + " " + price + " " + type + " " + quantityValue;

    }
}
