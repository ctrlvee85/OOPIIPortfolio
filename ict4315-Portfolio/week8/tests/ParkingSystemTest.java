package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import parkingsystem.*;

class ParkingSystemTest {

	private RegisterCarCommand regCar;
	private LocalDateTime timeIn = LocalDateTime.now().minusDays(3);
	private LocalDateTime timeOut = LocalDateTime.now();
	private RegisterCustomerCommand regCust;
	private PermitManager permits;
	private ParkingLot lot;
	private ParkingOffice office = new ParkingOffice("Main Office", "22 North Main St");
	private TransactionManagerList transactions = new TransactionManagerList();

	Customer allen = new Customer("Allen", "22 Browning St", "333-333-3333");
	Customer alvin = new Customer("Alvin", "44 Orange Ave", "444-444-4444");
	Customer aaron = new Customer("Aaron", "66 Red Rd", "555-555-5555");
	ParkingLot parkingLot = new ParkingLot("Parking Lot 12", "1200 University Way", 155, LotType.DAILY);
	ParkingLot parkingLot2 = new ParkingLot("Parking Lot 13", "1200 University Way", 500, LotType.EVENT);
	ParkingLot parkingLot3 = new ParkingLot("Parking Lot 14", "1200 University Way", 200, LotType.HOURLY);
	ParkingServiceSystem service = new ParkingServiceSystem();
	ParkingEvent parkingEvent = new ParkingEvent(parkingLot, timeIn, timeOut);

	Car car1 = new Car("222AAA", CarType.COMPACT);
	Car car2 = new Car("222BBB", CarType.SUV);
	Car car3 = new Car("555DCF", CarType.SUV);
	Car car4 = new Car("653HYR", CarType.COMPACT);

	Car reg1 = allen.registerCar("222AAA", CarType.COMPACT);
	Car reg2 = allen.registerCar("222BBB", CarType.SUV);
	Car reg3 = alvin.registerCar("555DCF", CarType.SUV);
	Car reg4 = aaron.registerCar("653HYR", CarType.COMPACT);

	@Test
	void decoratorTest() {
		parkingLot2.entry(car4, LotType.EVENT);
		assertNotNull(transactions.getCharge());

	}

	@Test
	void observerTest() {
		parkingLot3.entry(car2, LotType.EVENT);
		assertEquals(parkingLot.getCapacity(), 155);
		office.onParkingEventReceived(parkingEvent);

	}

	@Test
	void permitTest() {

		permits = new PermitManagerList();
		assertNotNull(permits.size());

	}

	@Test
	void customerTest2() {
		assertNotNull(reg4);
		assertNotNull(allen.getPermitID());
	}

	@Test
	void customerTest3() {
		assertEquals(allen.getAddress(), "22 Browning St");
		assertEquals(allen.getName(), "Allen");
	}

	@Test
	void customerTest4() {
		office.register(aaron, "Lot2", car1);
		assertNotNull(office.getCustomers());
		assertNotNull(office.getPermitID());
	}

	@Test
	void transactionTest() {
		transactions = new TransactionManagerList();
		parkingLot.entry(car2, LotType.DAILY);
		assertNotNull(transactions.getCharge());
	}

	@Test
	void serviceTest() {
		String[] params1 = { "Leon", "2 Orange St", "333-353-3323" };
		String[] params2 = { "Lisa", "3 Apple St", "554-353-3343" };
		String[] params3 = { "Lyle", "4 Grape St", "445-353-3433" };
		service.performCommand("Customer", params1);
		service.performCommand("Customer", params2);
		service.performCommand("Customer", params3);
		assertNotNull(service.getCommands());
		assertEquals(1, service.getCommands().size());
		assertTrue(service.getCommands().containsKey("Customer"));

	}

	@Test
	void serviceTest2() {
		String[] carString = { "567-880", CarType.SUV.toString() };
		service.performCommand("car", carString);
		assertNotNull(service.getArgs());
	}

}
