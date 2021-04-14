package airbnski.weather.client.api;

import airbnski.common.client.api.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientWeatherService extends ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientWeatherService.class);

    private final String listUrl = "";
    private final String baseUrl = "";
    private String id;

    public static void main(String[] args) {
        SpringApplication.run(ClientWeatherService.class, args);
    }
}


