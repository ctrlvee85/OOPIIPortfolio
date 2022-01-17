package parkingsystem;

/*Author: Jennifer McCall
* File: ParkingDecorator.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */

public abstract class ParkingDecorator implements ParkingChargeStrategy {
	protected double baseCharge = 24;
	private ParkingChargeStrategy charge;

	@Override
	public Double decorate() {
		return charge.decorate();

	};

}