package parkingsystem;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/*Author: Jennifer McCall
* File: PermitDirectoryList.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */

public class TransactionManagerList implements TrasactionManager {

	private ArrayList<ParkingCharge> charge = new ArrayList<>();
	private LocalDateTime timeOut;
	private int permitID;
	private ParkingLot parkingLot;

	@Override
	public void addCharge(ParkingCharge price) {
		charge.add(price);

	}

	@Override
	public int size() {
		return charge.size();
	}

	@Override
	public List<ParkingCharge> getCharge() {
		return charge;
	}

	@Override
	public void park(LocalDateTime timeOut, int permitID, ParkingLot parkingLot) {
		this.timeOut = timeOut;
		this.permitID = permitID;
		this.parkingLot = parkingLot;
	}
	
	


}
