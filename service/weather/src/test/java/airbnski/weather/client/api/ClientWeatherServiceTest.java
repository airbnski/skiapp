package airbnski.weather.client.api;

import airbnski.weather.client.model.GeolocationWeather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@ContextConfiguration(classes = {ClientWeatherService.class})
@ExtendWith(SpringExtension.class)
public class ClientWeatherServiceTest {
    @Autowired
    private ClientWeatherService clientWeatherService;

    @Test
    public void testReturnClass() {
        Class<GeolocationWeather> actualReturnClassResult = this.clientWeatherService.returnClass();
        assertSame(GeolocationWeather.class, actualReturnClassResult);
    }

    @Test
    public void testConstructor() {
        ClientWeatherService actualClientWeatherService = new ClientWeatherService();
        assertEquals("ea23cc4dee026bb20bf00f759f01d11e", actualClientWeatherService.getApiKey());
        assertEquals("https://api.openweathermap.org/data/2.5/weather?", actualClientWeatherService.getBaseUrl());
    }
}

