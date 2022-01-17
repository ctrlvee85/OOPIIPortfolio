package parkingsystem;

public class Hourly extends ParkingDecorator {
	
	public Hourly(ParkingChargeStrategy charge) {
		super();
	}

	@Override
	public Double decorate() {
		double money = baseCharge / 24;
		return money;

	};

}