package airbnski.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/")
    public String defaultHome(){
        return "airbnski microservice:weather running...";
    }
}
