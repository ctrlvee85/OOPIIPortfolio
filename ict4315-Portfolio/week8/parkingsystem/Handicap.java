package parkingsystem;
//Author: Jennifer McCall

public class Handicap extends ParkingDecorator {
	
	public Handicap(ParkingChargeStrategy charge) {
		super();
	}

	@Override
	public Double decorate() {
		double money = baseCharge * 0;
		return money;

	};
}