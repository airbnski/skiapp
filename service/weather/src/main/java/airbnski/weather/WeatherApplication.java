package airbnski.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"airbnski.weather", "airbnski.weather.client", "airbnski.weather.client.api", "airbnski.weather.client.model"})
public class WeatherApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
