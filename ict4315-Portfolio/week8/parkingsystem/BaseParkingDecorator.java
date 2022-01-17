package parkingsystem;

/*Author: Jennifer McCall
* File: ParkingDecorator.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */

public class BaseParkingDecorator implements ParkingChargeStrategy {

	@Override
	public Double decorate() {
		return 24.00;

	};

}