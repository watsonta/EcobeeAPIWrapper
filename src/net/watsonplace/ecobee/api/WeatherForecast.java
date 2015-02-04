package net.watsonplace.ecobee.api;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;

public class WeatherForecast extends APIObject {
	public static String[] APIObjectIdentifier = new String[] { "weatherforecast" };
	public static Type APIObjectType = new TypeToken<WeatherForecast>(){}.getType();
	
	HashMap<Integer, String> symbolMappings = new HashMap<Integer, String>();
	
	public WeatherForecast() {
		symbolMappings.put(-2, "no_symbol");
		symbolMappings.put(0, "sunny");
		symbolMappings.put(1, "few_clouds");
		symbolMappings.put(2, "partly_cloudy");
		symbolMappings.put(3, "mostly_cloudy");
		symbolMappings.put(4, "overcast");
		symbolMappings.put(5, "drizzle");
		symbolMappings.put(6, "rain");
		symbolMappings.put(7, "freezing_rain");
		symbolMappings.put(8, "showers");
		symbolMappings.put(9, "hail");
		symbolMappings.put(10, "snow");
		symbolMappings.put(11, "flurries");
		symbolMappings.put(12, "freezing_snow");
		symbolMappings.put(13, "blizzard");
		symbolMappings.put(14, "pellets");
		symbolMappings.put(15, "thunderstorm");
		symbolMappings.put(16, "windy");
		symbolMappings.put(17, "tornado");
		symbolMappings.put(18, "fog");
		symbolMappings.put(19, "haze");
		symbolMappings.put(20, "smoke");
		symbolMappings.put(21, "dust");
	}

	private Integer weatherSymbol; // The Integer value used to map to a weatherSymbol. See list of mappings above.
	private String dateTime; // The time stamp of the weather forecast.
	private String condition; // A text value reprsenting the current weather condition.
	private Integer temperature; // The current temperature.
	private Integer pressure; // The current barometric pressure.
	private Integer relativeHumidity; // The current humidity.
	private Integer dewpoint; // The dewpoint.
	private Integer visibility; // The visibility.
	private Integer windSpeed; // The wind speed as an integer in mph * 1000.
	private Integer windGust; // The wind gust speed.
	private String windDirection; // The wind direction.
	private Integer windBearing; // The wind bearing.
	private Integer pop; // Probability of precipitation.
	private Integer tempHigh; // The predicted high temperature for the day.
	private Integer tempLow; // The predicted low temperature for the day.
	private Integer sky; // The cloud cover condition.
		
	public HashMap<Integer, String> getSymbolMappings() {
		return symbolMappings;
	}

	public Integer getWeatherSymbol() {
		return weatherSymbol;
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getCondition() {
		return condition;
	}

	public Float getTemperature() {
		return temperature/10f;
	}

	public Integer getPressure() {
		return pressure;
	}

	public Integer getRelativeHumidity() {
		return relativeHumidity;
	}

	public Float getDewpoint() {
		return dewpoint/10f;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public Float getWindSpeed() {
		return windSpeed/1000f;
	}

	public Float getWindGust() {
		return windGust/1000f;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public Integer getWindBearing() {
		return windBearing;
	}

	public Integer getPop() {
		return pop;
	}

	public Float getTempHigh() {
		return tempHigh/10f;
	}

	public Float getTempLow() {
		return tempLow/10f;
	}

	public Integer getSky() {
		return sky;
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
