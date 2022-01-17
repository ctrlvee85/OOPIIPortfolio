package parkingsystem;

//Author: Jennifer McCall

//File:   ParkingLot.java

import java.time.LocalDateTime;

public class ParkingEvent {

	private ParkingLot parkingLot;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;

	public ParkingEvent(ParkingLot parkingLot, LocalDateTime timeIn, LocalDateTime timeOut) {
		this.parkingLot = parkingLot;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public LocalDateTime getTimeIn() {
		return timeIn;
	}

	public LocalDateTime getTimeOut() {
		return timeOut;
	}

}
