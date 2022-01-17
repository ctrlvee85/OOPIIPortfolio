package parkingsystem;

//Author: Jennifer McCall
//File:   Car.java

import java.time.LocalDate;

//Defines attributes of a customer's car
public class Car {
	private String permitID;
	private LocalDate expiration;
	private String license;
	private CarType type;
	private String carOwner;
	private String customerID;

	public String toString() {
		return "This car is owned by " + getCustomerID() + "and is a " + type.toString();
	}

	public Car(CarType type) {
		this.type = type;
	}

	public Car(String license, CarType type) {
		this.license = license;
		this.type = type;
		LocalDate date = LocalDate.now();
		expiration = date.plusDays(7);

	}

	public CarType getCarType() {
		return type;

	}

	public String getCustomerID() {
		return customerID;

	}

	
	public String getLicense() {
		return license;

	}

	public LocalDate getExpiration() {
		return expiration;

	}


}
