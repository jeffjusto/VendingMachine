package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Purchase;
import com.techelevator.view.Snacks;

import java.io.*;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class VendingMachineCLI {

	BigDecimal balance = new BigDecimal("0.00");

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_ITEM = "Select Item";
	private static final String PURCHASE_MENU_EXIT = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,
			PURCHASE_MENU_SELECT_ITEM,
			PURCHASE_MENU_EXIT};

	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
	LocalDateTime timeNow = LocalDateTime.now();
	String dateLog = timeNow.format(dateTime);

	private Menu menu;

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		Inventory updatedInventory = new Inventory();
		Inventory stock = new Inventory();
		List<Snacks> stockDisplay = stock.stockInventory();
		Purchase itemPurchase = new Purchase();

		File logFile = new File("log.txt");
		logFile.createNewFile();
		if (logFile.exists()) {
			PrintWriter purchaseLog = new PrintWriter(new FileWriter(logFile, false));



			boolean vendingLoop = true;
			while (vendingLoop) {
				String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
				System.out.println();

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					//METHOD TO DISPLAY MENU/INVENTORY
					for (Snacks item : stockDisplay) {
						System.out.printf("%-2s | %-20s | %-4s | %2s \n", item.getSlot(), item.getName(), "$" + item.getPrice(), item.getInventory());
					}



				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					boolean purchaseLoop = true;
					while (purchaseLoop) {
						String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

						if (purchaseChoice.equals(PURCHASE_MENU_FEED_MONEY)) {
							//METHOD TO FEED MONEY
							System.out.println("Select dollar amount $1, $5, $10, $20:");
							Scanner userInput = new Scanner(System.in);
							String dollarChoice = userInput.nextLine();
							balance = balance.add(new BigDecimal(dollarChoice));
							System.out.println("Your balance is: " + "$" + balance);
							purchaseLog.println(dateLog + " FEED MONEY " + "$" + dollarChoice + " " + balance);
							purchaseLog.flush();




						} else if (purchaseChoice.equals(PURCHASE_MENU_SELECT_ITEM)) {
							//METHOD FOR MENU SELECTION
							for (Snacks item : stockDisplay) {
								System.out.printf("%-2s | %-20s | %-4s | %2s \n", item.getSlot(), item.getName(), "$" + item.getPrice(), (item.getInventory()));
							}

							System.out.println("Select an item from the menu >>>");
							Scanner userInput = new Scanner(System.in);
							String selection = userInput.nextLine();
							BigDecimal zero = new BigDecimal("0");


							if (itemPurchase.updatedBalance(balance, selection).compareTo(zero) >= 0) {
								BigDecimal newBalance = itemPurchase.updatedBalance(balance, selection);

								balance = newBalance;

								System.out.println("Your new balance is: $" + balance);
								for (Snacks item : stockDisplay) {
									if (item.getSlot().equals(selection)) {
										System.out.println(item.getNoise());


								}
								purchaseLog.println(dateLog + item.getName() + " " + item.getSlot() + "$" + item.getPrice() + " " + balance);
								purchaseLog.flush();
								break;
							}
								for (Snacks item : stockDisplay) {
									if (item.getSlot().equals(selection)) {
										item.setInventory(item.getInventory() - 1);
										if (item.getInventory() < 0) {
											System.err.println("Item is SOLD OUT");
										}
									}
								}

							} else if (itemPurchase.updatedBalance(balance, selection).compareTo(zero) < 0) {
								System.err.println("Not enough money. Please feed more money.");
							}

						} else if (purchaseChoice.equals(PURCHASE_MENU_EXIT)) {
							itemPurchase.getChange(balance);
							purchaseLog.println(dateLog + " GIVE CHANGE " + balance + "0.00");
							purchaseLog.flush();
							purchaseLog.close();


							purchaseLoop = false;
						}
					}
				}
			}


		}
	}
}


