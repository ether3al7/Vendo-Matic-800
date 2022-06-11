package com.techelevator;

import com.techelevator.view.InventoryItem;
import com.techelevator.view.Menu;
import com.techelevator.view.Purchase;
import com.techelevator.view.VendingMachine;

import java.util.Map;
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

	private double amount;


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			VendingMachine v  = new VendingMachine();
			v.createVendingMachine();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				//created map to store .csv file, looping thru to get text
				//stored abstract class InventoryItem as value for map
				//looping thru using getters in sub classes to print values
				for (Map.Entry<String, InventoryItem> m : v.getVendingMachineStock().entrySet()){
					System.out.println(m.getKey() + "|" +  m.getValue().getName() + "|" +  m.getValue().getPrice() + "|Stock: " + m.getValue().getCurrentStock());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				String nextChoice = (String) menu.getChoiceFromOptions(PURCHASE_OPTIONS);

				if (nextChoice.equals(FEED_MONEY)){
					System.out.println("Please Enter Amount");
					double amountEntered = Double.parseDouble(sc.nextLine());
					// left as .nextLine since using nextDouble can create whitespace errors,
					// parsing as double
					if (amountEntered == 1 || amountEntered == 2 || amountEntered == 5 || amountEntered == 10) {
						// added double amount attribute to this class to store amount user inputs
						this.amount += amountEntered;
						System.out.println(" Current Money Provided: " + "$" + amount);
					} else {
						System.out.println("Not A Valid Whole Number");
					}
				} else if (nextChoice.equals(SELECT_PRODUCT)) {
					System.out.println("Enter Code");
					String codeEntered = sc.nextLine();
					for (Map.Entry<String, InventoryItem> m : v.getVendingMachineStock().entrySet()){
						//looping thru checking if enough money was fed and if key(code) exists
						if ( codeEntered.equals(m.getKey()) && amount >= m.getValue().getPrice()){
							amount -= m.getValue().getPrice();
							// subtracting amount fed based on which product was dispensed
							m.getValue().decreaseCurrentStock();// <-- still working on this

							System.out.println(m.getValue().dispense());
							// using dispense() method to print message
						} else if (codeEntered.equals(m.getKey()) && !(amount >= m.getValue().getPrice())) {
							System.out.println("Not Enough Money!");
							//if caught here, money is insufficient
						}
					}
					System.out.println("Amount Remaining: " + amount);
				} else if (nextChoice.equals(FINISH_TRANSACTION)) {
                   //working on this too
				}

			}else if (choice.equals(MAIN_MENU_EXIT)){
                System.exit(0);

			}
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
