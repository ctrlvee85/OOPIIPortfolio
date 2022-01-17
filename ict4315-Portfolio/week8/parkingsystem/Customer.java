package parkingsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Author: Jennifer McCall
//File:   Customer.java

public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private String type;
	private int customerID;
	private int permitID;
	private ParkingOffice office;
	private List<Car> cars = new ArrayList<>();

	public Customer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Car registerCar(String license, CarType type) {
		Car car = new Car(license, type);
		cars.add(car);

		return car;
	}

	public String toString() {
		return name.toString() + " owns a " + type.toString() + "and can be reached at " + phoneNumber.toString()
				+ ". This customer's address is " + address.toString();
	}

	public String getType() {
		return type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
//
	public void setPermitID(int permitID) {
		this.permitID = permitID;
	}

	public int getPermitID() {
		return permitID;
	}

	public void setCustomerID(int permitID) {
		this.customerID = customerID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Car[] getCars() {
		return cars.toArray(new Car[0]);

	}

	public ParkingOffice getOffice() {
		return office;
	}

}
