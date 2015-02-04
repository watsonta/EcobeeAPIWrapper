package net.watsonplace.ecobee.api;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

public class Runtime extends APIObject {
	public static String[] APIObjectIdentifier = new String[] { "runtime" };
	public static Type APIObjectType = new TypeToken<Runtime>(){}.getType();
	
	private String runtimeRev; // The current runtime revision. Equivalent in meaning to the runtime revision number in the thermostat summary call.
	private Boolean connected; // Whether the thermostat is currently connected to the server.
	private String firstConnected; // The UTC date/time stamp of when the thermostat first connected to the ecobee server.	
	private String connectDateTime; // The last recorded connection date and time.
	private String disconnectDateTime; // The last recorded disconnection date and time.
	private String lastModified; // The UTC date/time stamp of when the thermostat was updated. Format: YYYY-MM-DD HH:MM:SS
	private String lastStatusModified; // The UTC date/time stamp of when the thermostat last posted its runtime information. Format: YYYY-MM-DD HH:MM:SS
	private String runtimeDate; // The UTC date of the last runtime reading. Format: YYYY-MM-DD
	private Integer runtimeInterval; // The last 5 minute interval which was updated by the thermostat telemetry update. Subtract 2 from this interval to obtain the beginning interval for the last 3 readings. Multiply by 5 mins to obtain the minutes of the day. Range: 0-287
	private Integer actualTemperature; // The current temperature displayed on the thermostat.
	private Integer actualHumidity; // The current humidity % shown on the thermostat.
	private Integer desiredHeat; // The desired heat temperature as per the current running program or active event.
	private Integer desiredCool; // The desired cool temperature as per the current running program or active event.
	private Integer desiredHumidity; // The desired humidity set point.
	private Integer desiredDehumidity; // The desired dehumidification set point.
	private String desiredFanMode; // The desired fan mode. Values: auto, on or null if the HVAC system is off and the thermostat is not controlling a fan independently. 
	
	public String getRuntimeRev() {
		return runtimeRev;
	}

	public Boolean getConnected() {
		return connected;
	}

	public String getFirstConnected() {
		return firstConnected;
	}

	public String getConnectDateTime() {
		return connectDateTime;
	}

	public String getDisconnectDateTime() {
		return disconnectDateTime;
	}

	public String getLastModified() {
		return lastModified;
	}

	public String getLastStatusModified() {
		return lastStatusModified;
	}

	public String getRuntimeDate() {
		return runtimeDate;
	}

	public Integer getRuntimeInterval() {
		return runtimeInterval;
	}

	public Float getActualTemperature() {
		return actualTemperature/10f;
	}

	public Integer getActualHumidity() {
		return actualHumidity;
	}

	public Float getDesiredHeat() {
		return desiredHeat/10f;
	}

	public Float getDesiredCool() {
		return desiredCool/10f;
	}

	public Integer getDesiredHumidity() {
		return desiredHumidity;
	}

	public Integer getDesiredDehumidity() {
		return desiredDehumidity;
	}

	public String getDesiredFanMode() {
		return desiredFanMode;
	}

	@Override
	public String[] getAPIObjectIdentifier() {
		return APIObjectIdentifier;
	}

	@Override
	public String toJson() {
		return super.toJson(APIObjectIdentifier[0]);
	}
	
}
