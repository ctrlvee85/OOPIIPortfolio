package parkingsystem;

import java.text.NumberFormat;

// Author: Jennifer McCall
//File: Money.java

public class Money {
	private final long cents;
	private double dollars;
	private String amount;
	private static final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

	public Money() {
        cents = 0;
	}

	public Money(double amount) {
		cents = Math.round(amount * 100.0) ;
	}
	
	public double getDollars() {
		return cents / 100.0;
	}


	public String toString() {
		return moneyFormat.format(cents / 100.0);
	}
	
	public Money add(Money amount) {
		return new Money(cents + amount.cents);
	}

}
