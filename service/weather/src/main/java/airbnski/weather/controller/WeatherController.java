package airbnski.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WeatherController {
    @GetMapping("/")
    public String defaultHome(){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        String msg = "AirBNSki Weather Microservice is running on port:8081. "
        + "Note: Weather Microservice is not meant to be used externally & is used by other AirBNSki services. " +
                "Accessed On: "+ formatter.format(date);

        return msg;
    }
}
