package airbnski.common.client.api;

import airbnski.common.client.model.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ClientService<T> {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public Class<AbstractEntity> returnClass() {
        return AbstractEntity.class;
    }

    public String generateUrl(Integer id) {
        return this.getBaseUrl()+id+".json";
    }

    @Async
    public CompletableFuture<T> getResource(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String s = generateUrl(id);
        T response = (T) restTemplate.getForObject(s, returnClass());
        return CompletableFuture.completedFuture(response);
    }
}

