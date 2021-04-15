package airbnski.resort.service;

import airbnski.resort.client.api.ClientResortService;
import airbnski.resort.client.model.ClientResort;
import airbnski.resort.client.model.ClientResponse;
import airbnski.resort.generated.model.Resort;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("resortService")
public class ResortService {

    public static ClientResort getClientResort(Integer id) {
        ClientResortService clientResortService = new ClientResortService();
        ClientResort clientResort = (ClientResort) clientResortService.getResource(id);
        return clientResort;
    }

    public static ClientResponse[] getAllClientResorts() {
        ClientResortService clientResortService = new ClientResortService();
        ClientResponse[] allClientResorts = (ClientResponse[]) clientResortService.getAllResources();
        return allClientResorts;
    }

    /*public ClientWeather getClientWeather() {
        return clientWeather;
    }

    public void setClientSlope(ClientSlope clientSlope) {
        this.clientSlope = clientSlope;
    }*/

    public static Resort getResort(Integer id) {
        ClientResort clientResort = getClientResort(id);
        return convertClient(clientResort);
    }

    private static Resort convertClient(ClientResort clientResort) {
        Resort resort = new Resort();
        resort.setId(clientResort.getId());
        resort.setName(clientResort.getName());
        resort.setWebsite(clientResort.getWebsite());
        resort.setStatus(clientResort.getStatus());
        resort.setLongitude(clientResort.getLongitude());
        resort.setLatitude(clientResort.getLatitude());
        //resort.setImage(clientResort.getImage());
        resort.setSlope(null);
        resort.setWeather(null);
        return resort;
    }

    public static Resort[] getAllResorts() {
        ClientResponse[] allClientResorts = getAllClientResorts();
        Resort[] allResorts = Arrays.stream(allClientResorts).map(x -> convertClient(x.getResort())).toArray(Resort[]::new);
        return allResorts;
    }


}









