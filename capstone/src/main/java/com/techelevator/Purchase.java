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
                        } else {
                            System.out.println("You don't have enough money!! Oh no!");
                        }
                    }


                }catch (Exception e){
                    System.out.println("Please enter a valid item code.");
                }

            } else if (choice.equals(OPTION_SELECT_FINISH)) {
                break;
            }

        }
    }
}
