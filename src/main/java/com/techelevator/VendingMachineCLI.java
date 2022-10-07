package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Snacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_ITEM = "Select Item";
	private static final String PURCHASE_MENU_EXIT = "Exit to Main Menu";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,
			PURCHASE_MENU_SELECT_ITEM,
			PURCHASE_MENU_EXIT};

	private Menu menu;

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Inventory stock = new Inventory();
		List<Snacks> stockDisplay = stock.stockInventory();

		boolean vendingLoop = true;
		while (vendingLoop) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				//METHOD TO DISPLAY MENU/INVENTORY
				for (Snacks item : stockDisplay) {
					System.out.println(item.getSlot() + " | " + item.getName() + " | " + item.getPrice() + " | " + item.getInventory());
				}



			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean purchaseLoop = true;
				while (purchaseLoop) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						//METHOD TO FEED MONEY
					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_ITEM)) {
						//METHOD FOR MENU SELECTION
					} else if (purchaseChoice.equals(PURCHASE_MENU_EXIT)) {
						purchaseLoop = false;
					}
				}
			}
		}

	}
}


