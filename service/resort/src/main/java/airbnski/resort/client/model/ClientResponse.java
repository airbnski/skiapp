package airbnski.resort.client.model;

import airbnski.common.client.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponse extends AbstractEntity {

    public ClientResponse() {
    }

    @JsonProperty("SkiArea")
    private ClientResort resort;

    @JsonProperty("Region")
    private Region[] regions;

    public ClientResort getResort() {
        return resort;
    }

    public void setResort(ClientResort resort) {
        this.resort = resort;
    }

    public Region[] getRegion() {
        return regions;
    }

    public void setRegion(Region[] regions) {
        this.regions = regions;
    }
}
