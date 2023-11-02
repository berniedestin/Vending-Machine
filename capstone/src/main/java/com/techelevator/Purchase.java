package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.*;

public class Purchase {
    private static final String OPTION_FEED_MONEY = "Feed Money";
    private static final String OPTION_SELECT_PRODUCT = "Select Product";
    private static final String OPTION_SELECT_FINISH = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {OPTION_FEED_MONEY,OPTION_SELECT_PRODUCT,OPTION_SELECT_FINISH};
    private Menu menu;
    private Scanner input = new Scanner(System.in);

    public Purchase(){
        this.menu = new Menu(System.in, System.out);
    }

    public void run() {


        while (true) {
            System.out.println("Current Money Provided: $" +
                    VendingMachineCLI.getMachine().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP));
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(OPTION_FEED_MONEY)) {
                System.out.print("Please enter the dollar amount to insert: ");
                double amount = 0;
                try{
                    amount = Double.parseDouble(input.nextLine());
                    VendingMachineCLI.getMachine().setBalance(
                            VendingMachineCLI.getMachine().getBalance().add(new BigDecimal(amount)));
                    VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getFeedLog(new BigDecimal(amount)));
                    // delete below this
                    //System.out.println(VendingMachineCLI.getMachine().getLog().getFeedLog(new BigDecimal(amount)));
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid dollar amount!");
                }



            } else if (choice.equals(OPTION_SELECT_PRODUCT)) {
                // do purchase
                VendingMachineCLI.getMachine().getInventory().printInventoryList();
                System.out.print("Please enter an item code: ");
                try {
                    String code = input.nextLine().toUpperCase();

                    if(!VendingMachineCLI.getMachine().getInventory().getInventoryMap().containsKey(code)){
                        throw new Exception();
                    }
                    Item item = VendingMachineCLI.getMachine().getInventory().getInventoryMap().get(code);
                    if(item.getQuantity() == 0){
                        System.out.println(item.getName()
                        + " is sold out! Oh no!");
                    } else if(item.getQuantity() > 0){
                        if(VendingMachineCLI.getMachine().getBalance().compareTo(item.getPrice()) >= 0){
                            VendingMachineCLI.getMachine().setBalance(VendingMachineCLI.getMachine().getBalance().subtract(item.getPrice()));
                            item.setQuantity(item.getQuantity() - 1);

                            System.out.println("You bought " + item.getName() + " for $" + item.getPrice() + ", " + item.getMessage());
                            System.out.println("You have $" + VendingMachineCLI.getMachine().getBalance() + " left.");
                            VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getPurchaseLog(item));
                            //Delete below
                            //System.out.println(VendingMachineCLI.getMachine().getLog().getPurchaseLog(item));
                        } else {
                            System.out.println("You don't have enough money!! Oh no!");
                        }
                    }


                }catch (Exception e){
                    System.out.println("Please enter a valid item code.");
                }

            } else if (choice.equals(OPTION_SELECT_FINISH)) {
                getChange();
                VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getChangeLog());
                //Delete one below
                //System.out.println(VendingMachineCLI.getMachine().getLog().getChangeLog());
                VendingMachineCLI.getMachine().setBalance(new BigDecimal(0));
                break;
            }

        }
    }



    public void getChange() {

        System.out.println("Thank you for your purchase");

        String change = "Your change is ";
        int remainder = VendingMachineCLI.getMachine().getBalance().multiply(new BigDecimal(100)).intValue();

        if (remainder == 0) {
            change = "There is no change";
        }

        if (remainder % 500 == 0 && remainder > 0) {
            change += remainder / 500 + " $5 bill(s)";
            remainder -= (remainder / 500) * 500;
        } else if (remainder % 500 > 0 && remainder > 0) {
            change += remainder / 500 + " $5 bill(s), ";
            remainder -= (remainder / 500) * 500;
        }
        if (remainder % 100 == 0 & remainder > 0) {
            change += remainder / 100 + " $1 bill(s)";
            remainder -= (remainder / 100) * 100;
        } else if (remainder % 100 > 0 && remainder > 0) {
            change += remainder / 100 + " $1 bill(s), ";
            remainder -= (remainder / 100) * 100;
        }
        if (remainder % 25 == 0 && remainder > 0) {
            change += remainder / 25 + " quarter(s)";
            remainder -= (remainder / 25) * 25;
        } else if (remainder % 25 > 0 && remainder > 0) {
            change += remainder / 25 + " quarter(s), ";
            remainder -= (remainder / 25) * 25;
        }
        if (remainder % 10 == 0 && remainder > 0) {
            change += remainder / 10 + " dime(s)";
            remainder -= (remainder / 10) * 10;
        } else if (remainder % 10 > 0 && remainder > 0) {
            change += remainder / 10 + " dime(s), ";
            remainder -= (remainder / 10) * 10;
        }
        if (remainder % 5 == 0 && remainder > 0) {
            change += remainder / 5 + " nickel(s)";
            remainder -= (remainder / 5) * 5;
        } else if (remainder % 5 > 0 && remainder > 0) {
            change += remainder / 5 + " nickel(s), ";
            remainder -= (remainder / 5) * 5;
        }
        if (remainder > 0) {
            change += remainder + " penny(s)";
            remainder = 0;
        }

        System.out.println(change);
    }
}
