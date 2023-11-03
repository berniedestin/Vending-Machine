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
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED

    public Purchase(){
        this.menu = new Menu(System.in, System.out);
    }

    public void run() {

        while (true) {

            String outputColor = VendingMachineCLI.getMachine().getBalance().compareTo(new BigDecimal(0)) == 0 ?
                    RED_BOLD_BRIGHT :
                    GREEN_BOLD_BRIGHT;

            System.out.println("Current Money Provided: " + outputColor + "$" +
                    VendingMachineCLI.getMachine().getBalance().setScale(2, BigDecimal.ROUND_HALF_UP) + Inventory.RESET);
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(OPTION_FEED_MONEY)) {
                feedMoney();
            } else if (choice.equals(OPTION_SELECT_PRODUCT)) {
                // do purchase
                selectProduct();
            } else if (choice.equals(OPTION_SELECT_FINISH)) {
                getChange();
                VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getChangeLog());
                VendingMachineCLI.getMachine().setBalance(new BigDecimal(0));
                break;
            }

        }
    }

    public void feedMoney(){
        System.out.print("Please enter the dollar amount to insert: ");
        double amount = 0;
        try{
            amount = Double.parseDouble(input.nextLine());
            if (amount < 0) {
                throw new NumberFormatException();
            }
            VendingMachineCLI.getMachine().setBalance(
                    VendingMachineCLI.getMachine().getBalance().add(new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP)));
            VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getFeedLog(new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP)));

            VendingMachineCLI.getMachine().getSoundPlayer().playFeedMoney();
        }catch (NumberFormatException e){
            System.out.println("Please enter a valid dollar amount!");
        }
    }
    public void selectProduct(){
        VendingMachineCLI.getMachine().getInventory().printInventoryList();
        System.out.print("Please enter an item code: ");
//        SoundPlayer soundEffect = new SoundPlayer();
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

                    VendingMachineCLI.getMachine().getSoundPlayer().playBuyItem();

                    System.out.println("You bought " + item.getName() + " for $" + item.getPrice() + ", " + item.getMessage());
                    System.out.println("You have $" + VendingMachineCLI.getMachine().getBalance() + " left.");
                    VendingMachineCLI.getMachine().getLog().writeToLog(VendingMachineCLI.getMachine().getLog().getPurchaseLog(item));

                } else {
                    System.out.println("You don't have enough money!! Oh no!");

                    VendingMachineCLI.getMachine().getSoundPlayer().playSadSound();
                }
            }


        }catch (Exception e){
            System.out.println("Please enter a valid item code.");
        }
    }


    public void getChange() {

        System.out.println("Thank you for your purchase");
        int remainder = VendingMachineCLI.getMachine().getBalance().multiply(new BigDecimal(100)).intValue();
        Change change = new Change(remainder);
        System.out.println(change.getChange());

        VendingMachineCLI.getMachine().getSoundPlayer().playGetChange();

    }
}
