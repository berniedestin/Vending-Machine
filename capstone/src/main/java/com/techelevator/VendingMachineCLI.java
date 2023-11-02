package com.techelevator;

import com.techelevator.view.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_SECRET = "SECRET";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_SECRET };

	private Menu menu;
	private static Machine machine = new Machine();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {



		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				machine.getInventory().printInventoryList();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				Purchase purchase = new Purchase();
				purchase.run();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}else if (choice.equals(MAIN_MENU_OPTION_SECRET)) {
				System.out.println("You found the secret!");
			}

		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public static Machine getMachine() {
		return machine;
	}

}