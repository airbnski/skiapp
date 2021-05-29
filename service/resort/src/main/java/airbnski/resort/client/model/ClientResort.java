package airbnski.resort.client.model;

import airbnski.common.client.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResort extends AbstractEntity {

    public ClientResort() {
    }

    private String name;

    @JsonProperty("opening_year")
    private Long openingYear;

    @JsonProperty("official_website")
    private String website;

    @JsonProperty("operating_status")
    private String status;

    @JsonAlias("geo_lat")
    private Double latitude;

    @JsonAlias("geo_lng")
    private Double longitude;

    private Tag[] tags;

    @JsonProperty("ski_maps")
    private Slope[] slope;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOpeningYear() {
        return openingYear;
    }

    public void setOpeningYear(Long openingYear) {
        this.openingYear = openingYear;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public Slope[] getSlope() {
        return slope;
    }

    public void setSlope(Slope[] slope) {
        this.slope = slope;
    }
}
