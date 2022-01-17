//Author: Jennifer McCall

package client;

import java.io.Serializable;
import java.util.Map;

public class RequestData implements Serializable {

	private String commandName;
	private Map<String, String> data;

	public RequestData(String commandName, Map<String, String> data) {
		this.commandName = commandName;
		this.data = data;
	}

	public Map<String, String> getData() {
		return data;
	}

	public String getCommandName() {
		return commandName;
	}
}
