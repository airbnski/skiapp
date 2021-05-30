package airbnski.weather.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureTest {
    @Test
    public void testConstructor() {
        Temperature actualTemperature = new Temperature();
        actualTemperature.setTemp(10.0);
        assertEquals(10.0, actualTemperature.getTemp().doubleValue());
    }
}

