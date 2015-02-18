package net.watsonplace.ecobee.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.watsonplace.ecobee.api.Functions.FunctionType;
import net.watsonplace.ecobee.api.oauth2.OAuthUtils;

public class APIWrapper implements API {
	private static APIWrapper singleton = null;
	
	public static APIWrapper getInstance() throws Exception {
		if (singleton == null) {
			singleton = new APIWrapper();
		}
		return singleton;
	}
	
	private OAuthUtils oauthUtils = null;
	
	private APIWrapper() throws Exception {
		oauthUtils = new OAuthUtils();
	}
	
	@Override
	public Set<Thermostat> getThermostats() throws Exception {
		HashSet<APIObject> request = new HashSet<>();
		Selection selection = new Selection(Selection.SelType.registered, "");
		selection.setIncludeRuntime(true);
		selection.setIncludeWeather(true);
		request.add(selection);
		EcobeeResponse<APIObject> response = oauthUtils.getProtectedResource("/thermostat", request);
		Status status = response.getStatus();
		if (status.getCode() > 0) {
			throw new Exception("Request failed: Ecobee status code="+status.getCode()+", message="+status.getMessage());
		}
		Set<APIObject> returnObjects = response.getResponse();
		HashSet<Thermostat> returnSet = new HashSet<>();
		for (APIObject returnObject : returnObjects) {
			if (returnObject instanceof Thermostat) {
				returnSet.add((Thermostat) returnObject);
			}
		}
		return returnSet;
	}
	
	@Override
	public void setHold(int desiredHeatTemp, int desiredColdTemp, int holdHours) throws Exception {
		Functions functions = new Functions(new Selection(Selection.SelType.registered, ""));
		Map<String, String> holdParams = new HashMap<>();
		holdParams.put("holdHours", new Integer(holdHours).toString());
		holdParams.put("heatHoldTemp", new Integer(desiredHeatTemp*10).toString());
		holdParams.put("coolHoldTemp", new Integer(desiredColdTemp*10).toString());
		functions.add(FunctionType.setHold, holdParams);
		EcobeeResponse<APIObject> response = oauthUtils.postProtectedResource("/thermostat", functions.toJson());
		Status status = response.getStatus();
		if (status.getCode() > 0) {
			throw new Exception("Request failed: Ecobee status code="+status.getCode()+", message="+status.getMessage());
		}
	}
	
	@Override
	public void releaseHold() throws Exception {
		Functions functions = new Functions(new Selection(Selection.SelType.registered, ""));
		Map<String, String> holdParams = new HashMap<>();
		functions.add(FunctionType.resumeProgram, holdParams);
		EcobeeResponse<APIObject> response = oauthUtils.postProtectedResource("/thermostat", functions.toJson());
		Status status = response.getStatus();
		if (status.getCode() > 0) {
			throw new Exception("Request failed: Ecobee status code="+status.getCode()+", message="+status.getMessage());
		}
	}
	
	@Override
	public void sendMessage(String message) throws Exception {
		Functions functions = new Functions(new Selection(Selection.SelType.registered, ""));
		Map<String, String> msgParams = new HashMap<>();
		msgParams.put("text", message);
		functions.add(FunctionType.sendMessage, msgParams);
		EcobeeResponse<APIObject> response = oauthUtils.postProtectedResource("/thermostat", functions.toJson());
		Status status = response.getStatus();
		if (status.getCode() > 0) {
			throw new Exception("Request failed: Ecobee status code="+status.getCode()+", message="+status.getMessage());
		}
	}

}
