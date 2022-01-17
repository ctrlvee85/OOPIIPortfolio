package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import client.RequestData;
import client.ResponseData;
import parkingsystem.Car;
import parkingsystem.CarType;
import parkingsystem.Customer;
import parkingsystem.LotType;
import parkingsystem.ParkingLot;
import parkingsystem.ParkingOffice;
import parkingsystem.ParkingServiceSystem;
import parkingsystem.TransactionManagerList;
import java.time.LocalDateTime;

public class ParkingService {
	protected final ParkingOffice parkingOffice;

	public ParkingService(ParkingOffice parkingOffice) {
		this.parkingOffice = parkingOffice;
	}

	protected ResponseData handleInput(InputStream in) throws Exception {
		@SuppressWarnings("resource")
		// The scanner and input stream will be closed when we disconnect
		ObjectInputStream objectInputStream = new ObjectInputStream(in);
		RequestData requestData = (RequestData) objectInputStream.readObject();
		return performCommand(requestData);

	}

	private ResponseData performCommand(RequestData requestData) {

		ParkingServiceSystem service = new ParkingServiceSystem();
		TransactionManagerList charges = new TransactionManagerList();
		Map<String, String> args = requestData.getData();
		ResponseData responseData = new ResponseData();
		switch (requestData.getCommandName()) {
		case "CUSTOMER":
			
			try {
				String[] customerString = { args.get("Name"), args.get("Address"), args.get("Phone Number")};
				responseData.setResponse(service.performCommand("customer", customerString));
			}
			catch (Exception ex) {
				Logger.getLogger(ParkingService.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			break;
		case "CAR":
			
			try {
				String[] carString = {args.get("License"), args.get("Car Type")};
				responseData.setResponse(service.performCommand("car", carString));
			}
			catch (Exception ex) {
				Logger.getLogger(ParkingService.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			break;

		default:
			responseData.setSuccess(false);
			responseData.setError("Command is not found.");
		}
		System.out.println("Response: " + responseData.getResponse());
		return responseData;
	}

}
