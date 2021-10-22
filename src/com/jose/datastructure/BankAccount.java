package com.jose.datastructure;
import java.util.Random;

public class BankAccount {
	// defining Class Attributes for Checking Balance, Savings Balance and Account Number
	private double checkingBalance;
	private double savingsBalance;
	private String accountNumber;	// variable defined to hold the random ten digit account
	
	// defining Class Member (static)
	public static int numAccounts = 0;
	public static double totalAmount = 0;
	
	//Method to generate random ten digit account
	private static String randomDigitAccount() {  
		String digitAccount = "";
		Random randomNumber = new Random();
		//System.out.println(randomNumber);
		for(int i = 0; i < 10; i++) {
			digitAccount += randomNumber.nextInt(10);  //Ask how the class Random from util works, becuase If I do not add .nextInt(10) it did not  generate a number
			//System.out.println(digitAccount);
		}
		System.out.println("The Account number " + digitAccount + " was created successfully");
		System.out.println(" ");
		return digitAccount;
	}

	
	public BankAccount() {
		BankAccount.numAccounts = numAccounts + 1;
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		this.accountNumber = BankAccount.randomDigitAccount(); 
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}

	public double getSavingsBalance() {
		return this.savingsBalance;
	}

	public void depositMoney(double amount, String account) {
		if(account.equals("checking")) {
			this.checkingBalance += amount;
			BankAccount.totalAmount += amount;
		}else if(account.equals("savings")) {
			this.savingsBalance += amount;
			BankAccount.totalAmount += amount;
		}
	}

	public void withdrawMoney(double amount, String account) {
		boolean successful = false;
		if(account.equals("savings")) {
			// check if there is enough funds in your account
			if(this.savingsBalance - amount >= 0) {
				successful = true;
				this.savingsBalance -= amount;
				System.out.println("Your money was deposited in your Savings Account");
			}else {
				System.out.println("Funds are insufficient to withdraw money from  your Savings Account" );
			}
			
		}
		else if(account.equals("checking")) {
			// check if there is enough funds in your account
			if(this.checkingBalance - amount >= 0) {
				System.out.println("Your money was deposited in your Checking Account");
				successful = true;
				this.checkingBalance -= amount;
			}else {
				System.out.println("Funds are insufficient to withdraw money from  your Checking Account" );
			}
		}
		if(successful) {
			BankAccount.totalAmount -= amount;
		}
	}

	public void showAccountBalance() {
		System.out.println("Money available in your Savings: " + this.savingsBalance  );
		System.out.println("Money available in your Checking: " + this.checkingBalance );
	}
}