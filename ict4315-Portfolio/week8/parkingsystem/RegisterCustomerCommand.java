package parkingsystem;

import java.util.ArrayList;
import java.util.List;

//Author: Jennifer McCall
//File: RegisterCustomerCommand.java

public class RegisterCustomerCommand implements Command {

	private ParkingOffice office;
	private ParkingServiceSystem service;
	private String[] params;

	@Override
	public ParkingOffice getDisplayName(ParkingOffice office) {
		this.office = office;
		return this.office;
	}

	@Override
	public String getCommandName(ParkingServiceSystem service) {
		this.service = service;
		String rType = service.getRegType();
		return rType;
	}

	void checkParameters() {
		String[] params = service.getArgs();
	}

	@Override
	public String[] execute() {
		return params;
	}


}
