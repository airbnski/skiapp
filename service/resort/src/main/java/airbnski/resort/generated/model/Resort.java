package airbnski.resort.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Resort
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-13T17:50:21.484022+02:00[Europe/Zurich]")

public class Resort implements Comparable {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("website")
  private String website;

  @JsonProperty("status")
  private String status;

  @JsonProperty("longitude")
  private Double longitude;

  @JsonProperty("latitude")
  private Double latitude;

  @JsonProperty("distance")
  private Double distance;

  @JsonProperty("image")
  private String image;

  @JsonProperty("slope")
  private Slope slope = null;

  @JsonProperty("weather")
  private Weather weather = null;

  public Resort id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Resort name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Resort website(String website) {
    this.website = website;
    return this;
  }

  /**
   * Get website
   * @return website
  */
  @ApiModelProperty(value = "")

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Resort status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Resort longitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Get longitude
   * @return longitude
  */
  @ApiModelProperty(value = "")

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Resort latitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Get latitude
   * @return latitude
  */
  @ApiModelProperty(value = "")

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Resort distance(Double distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
  */
  @ApiModelProperty(value = "")

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public Resort image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  */
  @ApiModelProperty(value = "")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Resort slope(Slope slope) {
    this.slope = slope;
    return this;
  }

  /**
   * Get slope
   * @return slope
  */
  @ApiModelProperty(value = "")

  public Slope getSlope() {
    return slope;
  }

  public void setSlope(Slope slope) {
    this.slope = slope;
  }

  public Resort weather(Weather weather) {
    this.weather = weather;
    return this;
  }

  /**
   * Get weather
   * @return weather
  */
  @ApiModelProperty(value = "")

  public Weather getWeather() {
    return weather;
  }

  public void setWeather(Weather weather) {
    this.weather = weather;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resort resort = (Resort) o;
    return Objects.equals(this.id, resort.id) &&
        Objects.equals(this.name, resort.name) &&
        Objects.equals(this.website, resort.website) &&
        Objects.equals(this.status, resort.status) &&
        Objects.equals(this.longitude, resort.longitude) &&
        Objects.equals(this.latitude, resort.latitude) &&
        Objects.equals(this.distance, resort.distance) &&
        Objects.equals(this.image, resort.image) &&
        Objects.equals(this.slope, resort.slope) &&
        Objects.equals(this.weather, resort.weather);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, website, status, longitude, latitude, distance, image, slope, weather);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resort {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    slope: ").append(toIndentedString(slope)).append("\n");
    sb.append("    weather: ").append(toIndentedString(weather)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @Override
  public int compareTo(Object o) {
    Resort e = (Resort) o;
    return getDistance().compareTo(e.getDistance());
  }

  public boolean isWithinCoordinates(Double long1, Double lat1, Double distance) {
      if (distance == null ) distance = 50d;
      this.distanceFromCenter(long1, lat1);
      return true ? (this.distance<=distance) : false;
  }

  public void distanceFromCenter(Double long1, Double lat1){
    Double theta = long1 - longitude;
    Double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(latitude)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(theta));
    dist = Math.acos(dist);
    dist = rad2deg(dist);
    dist = dist * 60 * 1.1515;
    this.distance = dist;
  }
  private double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
  }

  private double rad2deg(double rad) {
    return (rad * 180.0 / Math.PI);
  }

}

