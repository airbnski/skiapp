package airbnski.resort.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortController {

    @GetMapping("/")
    public String defaultHome(){
        return "airbnski microservice:resort running...";
    }
}
