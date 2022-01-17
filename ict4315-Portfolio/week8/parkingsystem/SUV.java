package parkingsystem;
//Author: Jennifer McCall


public class SUV extends ParkingDecorator {
	
	public SUV(ParkingChargeStrategy charge) {
		super();
	}
	
	@Override
	public Double decorate() {
		double money = baseCharge;
		return money;

	};

}