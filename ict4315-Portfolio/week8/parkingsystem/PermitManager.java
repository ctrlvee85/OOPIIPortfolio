package parkingsystem;

/*Author: Jennifer McCall
* File: PermitDirectory.java
* interface based on in class example from week 8. This allows for adding of cars and customers to a permit directory.
* */

public interface PermitManager {
	/* 
	 * adds a customer to the directory
	 */
	int registerCustomer(Customer customer);
	/*
	 * Returns the number of customers in the directory
	 */
	int size(); 
	/*
	 * Returns an unmodifiable array of the customers in the directory
	 */
	Customer[] getCustomerByName(String nameMatch);

}
