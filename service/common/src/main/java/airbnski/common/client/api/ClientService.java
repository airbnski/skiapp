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

    private Integer id;
    private Double longitude;
    private Double latitude;
    private String apiKey;
    private String baseUrl;

    public Class<AbstractEntity> returnClass() {
        return AbstractEntity.class;
    }

    public String getApiKey() {
        return apiKey;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public Integer getId() {
        return id;
    }
    public String getBaseUrl() {
        return baseUrl;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String generateUrl() {
        if (getId() == null) return getBaseUrl()+"lat="+ getLatitude() +"&lon="+getLongitude()+"&appid="+getApiKey();
        return getBaseUrl()+getId()+".json";
    }

    @Async
    public CompletableFuture<T> getResource() {
        RestTemplate restTemplate = new RestTemplate();
        String s = generateUrl();
        T response = (T) restTemplate.getForObject(s, returnClass());
        return CompletableFuture.completedFuture(response);
    }
}

