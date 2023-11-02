package com.techelevator;

import java.io.File;
import java.math.BigDecimal;

public class Machine {

    private Inventory inventory;
    private BigDecimal balance;
    private Log log;
    private final String stockCSV = "vendingmachine.csv";


    public Machine() {

        File stock = new File(stockCSV);

        this.inventory = new Inventory(stock);
        this. balance = new BigDecimal("0");
        this.log = new Log();

    }

    public Inventory getInventory() {
        return inventory;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Log getLog() {
        return log;
    }

    public String getStockCSV() {
        return stockCSV;
    }
}