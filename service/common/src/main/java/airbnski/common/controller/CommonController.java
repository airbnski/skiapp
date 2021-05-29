package airbnski.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping("/")
    public String defaultHome(){
        return "airbnski microservice:common running...";
    }
}
