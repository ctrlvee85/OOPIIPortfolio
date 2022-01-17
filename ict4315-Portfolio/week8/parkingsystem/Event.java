package parkingsystem;
//Author: Jennifer McCall

public class Event extends ParkingDecorator {

	public Event(ParkingChargeStrategy charge) {
		super();
	}

	@Override
	public Double decorate() {
		double money = baseCharge * 2;
		return money;

	};

}
