package com.techelevator;

import java.io.File;
import java.math.BigDecimal;

public class Machine {

    private Inventory inventory;
    private BigDecimal balance;
    private Log log;
    private final String stockCSV = "vendingmachine.csv";
    private SoundPlayer soundPlayer = new SoundPlayer();
    private String vendomatic = "  _   __   ______   __   __   _____     _____           __   __     ____    ________  _______   _______ \n" +
            " | | / /  / ____/  /  \\ / /  /  _  \\   /  __ \\  ____   /  \\ /  |   / _  |  /__   __/ /__  __/  /  ____/\n" +
            " | |/ /  / ___/   / /\\ V /  /  /_|  | /  /_/ / /___/  / /| `/| |  / /_| |   /  /     __/ /__  /  /____\n" +
            " |___/  /_____/  /_/  \\_/  /_______/  \\_____/        /_/ |_/ |_| /_/``|_|  /__/     /______/  \\______/";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN


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
    public String getVendomatic(){
        return CYAN_BOLD_BRIGHT + vendomatic + Inventory.RESET;
    }

    public String getStockCSV() {
        return stockCSV;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}