package parkingsystem;

import java.time.LocalDateTime;
/*Author: Jennifer McCall
* File: PermitDirectory.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */
import java.util.ArrayList;
import java.util.List;

public interface TrasactionManager {
	/*
	 * adds a customer to the directory
	 */
	List<ParkingCharge> charge = new ArrayList<>();

	void addCharge(ParkingCharge parkingcharge);

	/*
	 * Returns the number of customers in the directory
	 */
	int size();

	/*
	 * Returns an unmodifiable array of the customers in the directory
	 */
	List<ParkingCharge> getCharge();
	
	void park(LocalDateTime timeOut, int permitID, ParkingLot parkingLot);
	



}
