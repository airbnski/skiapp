package airbnski.weather.client.api;

import airbnski.common.client.api.ClientService;
import airbnski.weather.client.model.GeolocationWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientWeatherService extends ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientWeatherService.class);

    private String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";

    private String apiKey = "ea23cc4dee026bb20bf00f759f01d11e";


    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public Class<GeolocationWeather> returnClass() {
        return GeolocationWeather.class;
    }
}





