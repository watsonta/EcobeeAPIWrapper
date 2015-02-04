package net.watsonplace.ecobee.api;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

class Version extends APIObject {
	public static String[] APIObjectIdentifier = new String[] { "version" };
	public static Type APIObjectType = new TypeToken<Version>(){}.getType();
	
	String thermostatFirmwareVersion; // The thermostat firmware version number.
	
	@Override
	public String[] getAPIObjectIdentifier() {
		return APIObjectIdentifier;
	}

	@Override
	public String toJson() {
		return super.toJson(APIObjectIdentifier[0]);
	}
	
}
