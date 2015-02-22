package net.watsonplace.ecobee.api;

import java.util.Set;

public interface API {
	
	public Set<Thermostat> getThermostats() throws Exception;
	
	public void setHold(String[] identifier, int desiredHeatTemp, int desiredColdTemp, int holdHours) throws Exception;
	
	public void releaseHold(String[] identifier) throws Exception;
	
	public void sendMessage(String[] identifier, String message) throws Exception;
	
}
