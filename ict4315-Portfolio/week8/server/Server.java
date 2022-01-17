package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import client.ResponseData;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;

public class Server {
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tc %4$-7s (%2$s) %5$s %6$s%n");
	}

	private static final Logger logger = Logger.getLogger(Server.class.getName());

	private final int PORT = 7777;

	private final ParkingService service;

	private Duration cumulativeDuration = Duration.ZERO;
	private int connectionCount = 0;
	private static volatile boolean doContinue = true;

	public static void stopServer() {
		doContinue = false;
		Thread.currentThread().interrupt();
		JOptionPane.showMessageDialog(null, "Server stopped.");
	}

	public Server(ParkingService service) {
		this.service = service;
	}

	public void startServer() throws Exception {
		logger.info("Starting server: " + InetAddress.getLocalHost().getHostAddress());
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			serverSocket.setReuseAddress(true);
			while (doContinue) {
				Socket client = serverSocket.accept();
				
				Instant start = Instant.now();
				
				Runnable r = new HandleRemoteClient(client, getService());
				new Thread(r).start();
				
				Instant done = Instant.now();
				
				cumulativeDuration = cumulativeDuration.plus(Duration.between(start,done));
				connectionCount++;
			}
			
			System.out.println("Handled " + connectionCount + " connections in " + cumulativeDuration);
			if (connectionCount > 0) {
				System.out.println("   "
						+ (cumulativeDuration.toNanos() / connectionCount)
						+ "ns. per connection");
			}
		}
	}
	
	public ParkingService getService() {
		return service;
	}


	/**
	 * Run this as: $ java ict4300.week8.server.Server
	 */
	public static void main(String[] args) throws Exception {
		parkingsystem.ParkingOffice parkingOffice = new parkingsystem.ParkingOffice("Office", "99 University Way");
		ParkingService service = new ParkingService(parkingOffice);

		new Server(service).startServer();
	}
}
