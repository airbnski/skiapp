package airbnski.common.client.rest;

import airbnski.common.client.domain.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class ConsumerService {

    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    private final String listUrl = "";
    private final String baseUrl = "";

    public static void main(String[] args) {
        SpringApplication.run(ConsumerService.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

    public String generateUrl(Long id) {
        return this.baseUrl+id+".json";
    }

    public AbstractEntity getResource(Long id) {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        AbstractEntity response = restTemplate.getForObject(this.generateUrl(id), AbstractEntity.class);
        log.info(response.toString());
        return response;
    }

    public AbstractEntity[] getAllResources() {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        AbstractEntity[] response = restTemplate.getForObject(this.listUrl, AbstractEntity[].class);
        log.info(response.toString());
        return response;
    }
}