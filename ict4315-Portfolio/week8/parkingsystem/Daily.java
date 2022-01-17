package parkingsystem;
//Author: Jennifer McCall


public class Daily extends ParkingDecorator {
	
	public Daily(ParkingChargeStrategy charge) {
		super();
	}

	@Override
	public Double decorate() {
		double money = baseCharge;
		return money;

	};

}