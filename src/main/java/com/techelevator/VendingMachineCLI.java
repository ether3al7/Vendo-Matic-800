package com.techelevator;


import com.techelevator.view.LogItems;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

import java.io.File;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };
	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		VendingMachine v  = new VendingMachine(); // <-- THIS was initially inside the While(True), in line 35, new instance was created everytime
		// in a new instance of vendingMachine, amount is initialized to 0, currentStock is set to 5;
		v.createVendingMachine();

		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

			     v.displayVendingMachine(); // <-- displays vending machine items

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) { // added this line to keep user in PURCHASE_OPTIONS array
					// After the product is dispensed, the machine must update its balance accordingly AND return the customer to the Purchase menu.
					String nextChoice = (String) menu.getChoiceFromOptions(PURCHASE_OPTIONS);

					if (nextChoice.equals(FEED_MONEY)) {

						System.out.println("Please Enter Amount");
						double amountEntered = Double.parseDouble(sc.nextLine());
						v.feedMoney(amountEntered); // <-- Enters money into vendingMachine, takes in double parameter


					} else if (nextChoice.equals(SELECT_PRODUCT)) {

						System.out.println("Enter Code");
						String codeEntered = sc.nextLine();
						v.selectProduct(codeEntered);   // <-- Selecting product, takes in String parameter

					} else if (nextChoice.equals(FINISH_TRANSACTION)) {
						 v.giveChange(); // <-- prints change in coins
                         break; // <-- ends true loop
					}
				}

			}else if (choice.equals(MAIN_MENU_EXIT)){
                System.exit(0); // <-- Terminates program
			}
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
