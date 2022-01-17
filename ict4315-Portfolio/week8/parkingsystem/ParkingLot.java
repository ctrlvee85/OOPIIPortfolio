package parkingsystem;

//Author: Jennifer McCall

//File:   ParkingLot.java

import java.util.ArrayList;
import java.time.Instant;

public class ParkingLot {
	String name;
	private String address;
	private int capacity;
	private String hours2;
	private static int baseCharge = 24;
	private LotType lotID;
	private static int price;
	private Money lotBaseCharge;
	private Money finalCharge;
	private Double factoryCharge;
	private ParkingOffice parkingOffice;
	private ParkingObserver parkingObserver;
	private String parkType;
	private ParkingCharge charge;

	public ParkingLot(String name, String address, int capacity, LotType lotID) {
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.lotID = lotID;
	}
	
	

	public ParkingLot(ParkingLot lot) {
	}

	public void entry(Car c, LotType lotID) {
		Money baseCharge = new Money();
		ParkingChargeStrategy hourly = new Hourly(new BaseParkingDecorator());
		ParkingChargeStrategy handicap = new Handicap(new BaseParkingDecorator());
		ParkingChargeStrategy compact = new Compact(new BaseParkingDecorator());
		ParkingChargeStrategy suv = new SUV(new BaseParkingDecorator());
		ParkingChargeStrategy event = new Event(new BaseParkingDecorator());
		ParkingChargeStrategy daily = new Daily(new BaseParkingDecorator());
		ParkingCharge charge = new ParkingCharge(lotID, baseCharge);
		TransactionManagerList charges = new TransactionManagerList();
		

		this.lotID = lotID;
		if (c.getCarType() == CarType.COMPACT) {
			parkType = c.getCarType().name();
			factoryCharge = compact.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);
			

		}
		if (c.getCarType() == CarType.HANDICAP) {
			parkType = c.getCarType().name();
			factoryCharge = handicap.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);

		}
		if (c.getCarType() == CarType.SUV) {
			parkType = c.getCarType().name();
			factoryCharge = suv.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);

		}

		if (lotID == LotType.HOURLY) {
			parkType = c.getCarType().name();
			factoryCharge = hourly.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);

		}
		if (lotID == LotType.EVENT) {
			parkType = c.getCarType().name();
			factoryCharge = event.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);

		} else {
			parkType = c.getCarType().name();
			factoryCharge = daily.decorate();
			baseCharge = new Money(factoryCharge);
			charges.addCharge(charge);

		}
	}

	public int getCapacity() {
		return capacity;
	}

	public String getName() {
		return name;
	}

	public LotType getLotType() {
		return lotID;

	}

	public String getAddress() {
		return address;
	}

	public Money getAmount() {
		return lotBaseCharge;
	}
	
	public void setParkingObserver(ParkingObserver parkingObserver) {
		this.parkingObserver = parkingObserver;
	}
	
	public void notify(ParkingEvent event) {
		System.out.println(String.format("Parking notification from lot %s", this.lotID));
		parkingObserver.onParkingEventReceived(event);
	}

}
