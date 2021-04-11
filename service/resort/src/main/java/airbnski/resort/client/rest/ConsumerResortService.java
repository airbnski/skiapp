package airbnski.resort.client.rest;

import airbnski.common.client.rest.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerResortService extends ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(ConsumerResortService.class);

    private final String listUrl = "https://skimap.org/SkiAreas/index.json";
    private final String baseUrl = "https://skimap.org/SkiAreas/view/";
    private String id;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerResortService.class, args);
    }
}


