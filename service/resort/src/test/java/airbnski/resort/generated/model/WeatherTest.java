package airbnski.resort.generated.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WeatherTest {
    @Test
    public void testEquals() {
        assertFalse((new Weather()).equals("42"));
        assertFalse((new Weather()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(961, (new Weather()).hashCode());
    }

    @Test
    public void testConstructor() {
        Weather actualWeather = new Weather();
        actualWeather.outlook("Outlook");
        actualWeather.setOutlook("Outlook");
        actualWeather.setTemperature(10.0);
        actualWeather.temperature(10.0);
        assertEquals("Outlook", actualWeather.getOutlook());
        assertEquals(10.0, actualWeather.getTemperature().doubleValue());
        assertEquals("class Weather {\n    temperature: 10.0\n    outlook: Outlook\n}", actualWeather.toString());
    }
}

