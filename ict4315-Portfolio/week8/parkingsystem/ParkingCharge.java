package parkingsystem;

import java.time.Instant;

//Author: Jennifer McCall
//File: ParkingCharge.java

public class ParkingCharge {
	private int permitID;
	private LotType lotID;
	private Instant incurred = Instant.now();
	private Money amount;

	public ParkingCharge(LotType lotID, Money amount) {
		this.lotID = lotID;
		this.amount = amount;
	}

	public Instant getIncurred() {
		return incurred;
	}

	public Money getAmount() {
		return amount;
	}
	


}
