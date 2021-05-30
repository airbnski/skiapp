package airbnski.weather.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class GeolocationWeatherTest {
    @Test
    public void testConstructor() {
        GeolocationWeather actualGeolocationWeather = new GeolocationWeather();
        Temperature temperature = new Temperature();
        actualGeolocationWeather.setTemperature(temperature);
        actualGeolocationWeather.setWeather(new Weather[]{new Weather()});
        assertSame(temperature, actualGeolocationWeather.getTemperature());
    }
}

