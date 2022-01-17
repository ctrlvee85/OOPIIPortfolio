package parkingsystem;

public interface Command {
	
	String getCommandName(ParkingServiceSystem service);
	ParkingOffice getDisplayName(ParkingOffice office);
	String[] execute();
	
	

}
