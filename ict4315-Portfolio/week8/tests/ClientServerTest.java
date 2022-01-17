package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import client.RequestData;
import client.ResponseData;
import client.Client;
import client.ParkingGui;
import server.HandleRemoteClient;
import server.ParkingService;
import server.Server;
import parkingsystem.ParkingServiceSystem;
import parkingsystem.ParkingLot;
import parkingsystem.ParkingOffice;
import parkingsystem.TransactionManagerList;
import parkingsystem.PermitManager;
import parkingsystem.Customer;
import parkingsystem.Car;
import parkingsystem.CarType;
import parkingsystem.LotType;
import parkingsystem.RegisterCarCommand;
import parkingsystem.RegisterCustomerCommand;

class ClientServerTest {
	@SuppressWarnings("static-access")
	@Before
	public void beforeFunction() throws Exception {

		server.startServer();
	}

	private RegisterCarCommand regCar;
	private LocalDateTime timeIn = LocalDateTime.now().minusDays(3);
	private LocalDateTime timeOut = LocalDateTime.now();
	private RegisterCustomerCommand regCust;
	private PermitManager permits;
	private ParkingLot lot;
	private ResponseData response;
	private Server server;
	private ParkingService service2;
	private ParkingOffice office = new ParkingOffice("Main Office", "22 North Main St");
	private TransactionManagerList transactions = new TransactionManagerList();

	Customer allen = new Customer("Allen", "22 Browning St", "333-333-3333");
	Customer alvin = new Customer("Alvin", "44 Orange Ave", "444-444-4444");
	Customer aaron = new Customer("Aaron", "66 Red Rd", "555-555-5555");
	ParkingLot parkingLot = new ParkingLot("Parking Lot 12", "1200 University Way", 155, LotType.DAILY);
	ParkingLot parkingLot2 = new ParkingLot("Parking Lot 13", "1200 University Way", 500, LotType.EVENT);
	ParkingLot parkingLot3 = new ParkingLot("Parking Lot 14", "1200 University Way", 200, LotType.HOURLY);
	ParkingServiceSystem service = new ParkingServiceSystem();

	Car car1 = new Car("222AAA", CarType.COMPACT);
	Car car2 = new Car("222BBB", CarType.SUV);
	Car car3 = new Car("555DCF", CarType.SUV);
	Car car4 = new Car("653HYR", CarType.COMPACT);

	Car reg1 = allen.registerCar("222AAA", CarType.COMPACT);
	Car reg2 = allen.registerCar("222BBB", CarType.SUV);
	Car reg3 = alvin.registerCar("555DCF", CarType.SUV);
	Car reg4 = aaron.registerCar("653HYR", CarType.COMPACT);

	@Test
	void systemTest() throws IOException {
		String[] carString = {"222AAA", "SUV"};
		service.performCommand("Car", carString);
		assertNotNull(office.cars);

	}

	@Test
	void systemTest2() throws IOException {
		String[] customerString = {"Allen", "22 Browning St", "333-333-3333"};
		service.performCommand("customer", customerString);
		assertNotNull(office.getCustomers());

	}
	
	@BeforeClass
    public void init() throws Exception {
		server.main(null);
    }
	
	@Test
	void systemTest3() throws Exception {
		boolean exceptionStatus =false;

		try {
		
		server.stopServer();
		} catch (RuntimeException E) {
			exceptionStatus=true;
		}
		finally {
		assertEquals(false, exceptionStatus);
		}

	}





}
