package airbnski.resort.client.model;

import airbnski.common.client.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

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
    private BigDecimal latitude;

    @JsonAlias("geo_lng")
    private BigDecimal longitude;

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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
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
