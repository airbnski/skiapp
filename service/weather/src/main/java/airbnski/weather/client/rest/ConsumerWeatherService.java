package airbnski.weather.client.rest;

import airbnski.common.client.rest.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerWeatherService extends ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(ConsumerWeatherService.class);

    private final String listUrl = "";
    private final String baseUrl = "";
    private String id;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerWeatherService.class, args);
    }
}


