package airbnski.resort.client.api;

import airbnski.common.client.api.ClientService;
import airbnski.resort.client.model.ClientResort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientResortService extends ClientService{
    private static final Logger log = LoggerFactory.getLogger(ClientResortService.class);

    private String baseUrl = "https://skimap.org/SkiAreas/view/";

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public Class<ClientResort> returnClass() {
        return ClientResort.class;
    }
}


