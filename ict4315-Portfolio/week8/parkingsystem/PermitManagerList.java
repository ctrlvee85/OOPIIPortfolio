package parkingsystem;

import java.util.ArrayList;
import java.util.List;

/*Author: Jennifer McCall
* File: PermitDirectoryList.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */

public class PermitManagerList implements PermitManager {

	private List<Customer> customer = new ArrayList<>();

	@Override
	public int registerCustomer(Customer cust) {
		customer.add(cust);
		return size();
	}

	@Override
	public int size() {
		return customer.size();
	}

	@Override
	public Customer[] getCustomerByName(String nameMatch) {
		// TODO Auto-generated method stub
		return null;
	}

}
