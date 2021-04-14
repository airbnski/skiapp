package airbnski.resort.client.api;

import airbnski.common.client.api.ClientService;
import airbnski.resort.client.model.ClientResort;
import airbnski.resort.client.model.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientResortService extends ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientResortService.class);

    private String listUrl = "https://skimap.org/SkiAreas/index.json";
    private String baseUrl = "https://skimap.org/SkiAreas/view/";
    private ClientResort response;

    @Override
    public String getListUrl() {
        return listUrl;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public Class<ClientResort> returnClass() {
        return ClientResort.class;
    }

    @Override
    public Class<ClientResponse[]> returnAllClass() {
        return ClientResponse[].class;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientResortService.class, args);
    }
}


