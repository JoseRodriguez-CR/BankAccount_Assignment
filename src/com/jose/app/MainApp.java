package com.jose.app;
import com.jose.datastructure.BankAccount;

public class MainApp {
	public static void main(String[] args) {
		BankAccount UserkAccount = new BankAccount();
		UserkAccount.depositMoney(0.50, "checking");
		UserkAccount.depositMoney(25.00, "savings");
		UserkAccount.showAccountBalance();
		
		System.out.println("Total Amount of Money in our bank is: " );
		System.out.println(BankAccount.totalAmount);
		System.out.println(" ");

		UserkAccount.withdrawMoney(50, "checking");
		UserkAccount.withdrawMoney(150, "savings");
		UserkAccount.showAccountBalance();

		System.out.println("Total Amount of Money in our bank is: " );
		System.out.println( BankAccount.totalAmount);
		System.out.println(" ");
	}
}

