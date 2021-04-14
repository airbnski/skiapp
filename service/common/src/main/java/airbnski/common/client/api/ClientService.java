package airbnski.common.client.api;

import airbnski.common.client.model.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class ClientService<T> {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private String listUrl;
    private String baseUrl;

    public String getListUrl() {
        return listUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Class<AbstractEntity> returnClass() {
        return AbstractEntity.class;
    }

    public Class<AbstractEntity[]> returnAllClass() {
        return AbstractEntity[].class;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientService.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(250000))
                .setReadTimeout(Duration.ofMillis(250000))
                .build();
    }

    public String generateUrl(Integer id) {
        return this.getBaseUrl()+id+".json";
    }

    public AbstractEntity getResource(Integer id) {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        AbstractEntity response = restTemplate.getForObject(this.generateUrl(id), returnClass());
        log.info(response.toString());
        return response;
    }

    public AbstractEntity[] getAllResources() {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        AbstractEntity[] response = restTemplate.getForObject(this.getListUrl(), returnAllClass());
        log.info(response.toString());
        return response;
    }
}