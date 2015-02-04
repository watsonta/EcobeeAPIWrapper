package net.watsonplace.ecobee.api;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

public class Weather extends APIObject {
	public static String[] APIObjectIdentifier = new String[] { "weather" };
	public static Type APIObjectType = new TypeToken<Weather>(){}.getType();
	
	private String timestamp; // The time stamp in UTC of the weather forecast.
	private String weatherStation; // The weather station identifier.
	private WeatherForecast[] forecasts; // The list of latest weather station forecasts.
	
	public String getTimestamp() {
		return timestamp;
	}

	public String getWeatherStation() {
		return weatherStation;
	}

	public WeatherForecast[] getForecasts() {
		return forecasts;
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
