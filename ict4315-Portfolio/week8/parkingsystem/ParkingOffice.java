package parkingsystem;

import java.time.LocalDateTime;

//Author: Jennifer McCall

//File: ParkingOffice.java

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class ParkingOffice implements ParkingObserver {

	private PermitManager permits;
	private TransactionManagerList charges = new TransactionManagerList();
	private String name;
	private String address;
	private String office;
	private List<Customer> listOfCustomers;
	private List<Car> listOfCars;
	public List<Car> cars;
	private int custID;
	private int permID;
	private String cID;
	private int customerID;
	private String pID;
	private int permitID;
	private String parkingOfficeName;
	private ParkingEvent parkingEvent;
	private Customer customer;
	private LocalDateTime timeOut;

	public int hashCodeCust(String name) {
		for (Customer c : listOfCustomers) {
			if (c.equals(name)) {
				custID = c.hashCode();
				setCustomerID(custID);

			}
			;
		}
		return custID;
	}

	public int hashCodePerm(String name) {
		for (Car c : cars) {
			if (c.equals(name)) {
				permID = c.hashCode();
				setPermitID(permID);

			}
			;
		}
		return permID;
	}

	public String getCustomerIDs() {
		for (int i = 0; i < cars.size(); i++) {
			String cID = cars.get(2).toString();
		}
		return cID;
	}

	public String getPermitIDs() {
		for (int i = 0; i < cars.size(); i++) {
			String pID = cars.get(3).toString();
		}
		return pID;
	}

	public ParkingOffice(String parkingOfficeName, String address) {
		this.parkingOfficeName = parkingOfficeName;
		this.address = address;
		listOfCustomers = new ArrayList<>();
		cars = new ArrayList<>();
	}

	public Customer register(Customer customer, String office, Car car) {
		customer.setPermitID(permID);
		customer.setName(name);
		office = office;
		setParkingOfficeName(office);
		listOfCustomers.add(customer);
		return customer;
	}

	public Car registerCar(String license, CarType type) {
		Car car = new Car(license, type);
		cars.add(car);
		listOfCars.add(car);
		return car;
	}

	public void registerCustomer(Customer customer) {
		permits = new PermitManagerList();
		permits.registerCustomer(customer);
	}

	public String getParkingOfficeName() {
		return parkingOfficeName;
	}

	public void setParkingOfficeName(String parkingOfficeName) {
		this.parkingOfficeName = parkingOfficeName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public List<Customer> getCustomers() {
		return listOfCustomers;
	}

	public List<Car> getCars() {
		return listOfCars;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getPermitID() {
		return permitID;
	}

	public void setPermitID(int permitID) {
		this.permitID = permitID;
	}

	@Override
	public String toString() {
		return "The parking office has " + permits.size() + " permits.";
	}
	
	@Override
	public void onParkingEventReceived(ParkingEvent parkingEvent) {
		charges.park(parkingEvent.getTimeOut(), permitID, parkingEvent.getParkingLot());
	}
	

}
