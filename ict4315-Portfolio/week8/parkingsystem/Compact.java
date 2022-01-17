package parkingsystem;
//Author: Jennifer McCall



public class Compact extends ParkingDecorator {
	
	public Compact(ParkingChargeStrategy charge) {
		super();
	}

	@Override
	public Double decorate() {
		double money = baseCharge * 0.8;
		return money;

	};

}
