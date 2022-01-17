// Author: Jennifer McCall

package server;

import client.ResponseData;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleRemoteClient implements Runnable {

	private Socket client;
	private ParkingService service;

	private static final Logger logger = Logger.getLogger(Server.class.getName());

	public HandleRemoteClient(Socket s, ParkingService service) {
		client = s;
		this.service = service;

	}

	@Override
	public void run() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream());
			InputStream isw = client.getInputStream();

			ResponseData output;
			try {
				synchronized (service) {
					output = service.handleInput(isw);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				output = new ResponseData(false, ex.getMessage(), null);
			}

			os.writeObject(output);
			os.flush();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Failed to read from client", e);
		} finally {
			try {

				client.close();
			} catch (IOException e) {
				logger.log(Level.WARNING, "Failed to close client socket", e);
			} finally {
			}
		}
	}

}
