package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
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


		boolean vendingLoop = true;
		while (vendingLoop) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				//METHOD TO DISPLAY MENU/INVENTORY

					File inputFile = new File("vendingmachine.csv");
					Scanner inputScanner = null;
					try {
						inputScanner = new Scanner(inputFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					while (inputScanner.hasNextLine()) {
						String line = inputScanner.nextLine();
						String[] products = line.split("\\|");
						System.out.println(products[0] + " | " + products[1] + " | " + products[2]);

					}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean purchaseLoop = true;
				while (purchaseLoop) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
						//METHOD TO FEED MONEY
					} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_ITEM)) {
						File inputFile = new File("vendingmachine.csv");
						Scanner inputScanner = null;
						try {
							inputScanner = new Scanner(inputFile);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

						while (inputScanner.hasNextLine()) {
							String line = inputScanner.nextLine();
							String[] products = line.split("\\|");
							System.out.println(products[0] + " | " + products[1] + " | " + products[2]);

						}
						//METHOD FOR MENU SELECTION
					} else if (purchaseChoice.equals(PURCHASE_MENU_EXIT)) {
						purchaseLoop = false;
					}
				}
			}
		}

	}
}


