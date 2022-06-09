package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Purchase;
import com.techelevator.view.VendingMachine;

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
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				VendingMachine v  = new VendingMachine();
				v.displayVendingMachine();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase

				Purchase p = new Purchase();
//				p.feedMoney();
				p.printPurchaseMenu();

				int userInput = sc.nextInt();
				if (userInput == 1){

					p.feedMoney();
					System.out.println("\n");

					p.printPurchaseMenu();
					userInput = sc.nextInt();

				}else if (userInput == 2){


				}else if (userInput == 3){

				}else{
					System.out.println("Not a valid input");
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
