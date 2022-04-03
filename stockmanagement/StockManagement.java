/*@Purpose : Stock Account Management
 * Get i/p from user about stock name ,price per stock
 * & no of stocks and store the information and display
 * as per user choice.
 * @file : Stock Management
 * @author : Kishlay Kishan
 */

package com.blz.stockmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StockManagement {
	ArrayList<String> stockName = new ArrayList<String>();
	ArrayList<Integer> numberOfShares = new ArrayList<Integer>();
	ArrayList<Integer> sharePrice = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);
	int balance = 1000;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			StockManagement obj = new StockManagement();
			while (true) {
				System.out.println(
						"1-Enter New Stock \n2-Display Stock Report \n3-Withdraw Amount From Balance \n4-Exit");
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					obj.addStocks();
					break;
				case 2:
					obj.stockReport();
					break;
				case 3:
					obj.debit();
					break;
				case 4: {
					System.out.println("Good Bye");
					System.exit(0);
				}
				default:
					System.out.println("Invalid Input");
				}
			}
		}
	}

	private void addStocks() {

		System.out.print("Enter the stock name: ");
		stockName.add(sc.next());

		System.out.print("Enter number of shares present: ");
		numberOfShares.add(sc.nextInt());

		System.out.print("Enter price of each share: ");
		sharePrice.add(sc.nextInt());

	}

	private void stockReport() {
		int sum = 0;
		System.out.println("***************STOCK REPORT****************");
		for (int i = 0; i < stockName.size(); i++) {
			int total = (numberOfShares.get(i) * sharePrice.get(i));
			balance = balance - total;
			sum = sum + total;
			System.out.println("Stock name= " + stockName.get(i) + "\nValue of each share= " + sharePrice.get(i)
					+ "\nTotal value of share= " + total);
			System.out.println(" Balance remaining : " + balance);

		}
	}

	private void debit() {
		System.out.println("Enter the amount you want to withdraw: ");
		int withdraw = sc.nextInt();
		if (withdraw < balance) {
			balance = balance - withdraw;
			System.out.println("Total amount left after withdrawal= " + balance);
		} else
			System.out.println("Debit amount exceeded account balance");

	}

}
