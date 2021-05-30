package airbnski.weather.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {
    @Test
    public void testConstructor() {
        Weather actualWeather = new Weather();
        actualWeather.setMain("Main");
        assertEquals("Main", actualWeather.getMain());
    }
}

