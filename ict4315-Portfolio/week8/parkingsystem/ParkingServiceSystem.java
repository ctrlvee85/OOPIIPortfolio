package parkingsystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Author: Jennifer McCall
//File: ParkingService.java

public class ParkingServiceSystem {

	private ParkingOffice office;
	private Command command;
	private String registrationType;
	private String[] args;
	private String regType;
	private Map<String, String[]> commands = new HashMap<String, String[]>();
	private CarType carType;

	String params = Arrays.toString(getArgs());

	void register() {
		if(regType == "customer") {
			Customer customer = new Customer(params, params, params);
			office.registerCustomer(customer);
		}
		else {
			
			String params = Arrays.toString(getArgs());
			if (params.contains("SUV")){
				CarType carType = CarType.SUV;
			}
			else {
				CarType carType = CarType.COMPACT;
			}
			office.registerCar(params, carType);
		}

	}

	public String performCommand(String registrationType, String[] parameters) {
		this.regType = registrationType;
		this.args = parameters;

		commands.put(regType, args);
		return regType;
	}

	public String[] getArgs() {
		return args;
	}
	
	public Map<String, String[]> getCommands() {
		return commands;
	}

	String getRegType() {
		return regType;
	}

}
