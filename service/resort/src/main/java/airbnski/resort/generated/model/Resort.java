package airbnski.resort.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Resort
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-13T17:50:21.484022+02:00[Europe/Zurich]")

public class Resort   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("website")
  private String website;

  @JsonProperty("slope")
  private Object slope = null;

  @JsonProperty("tempretature")
  private BigDecimal tempretature;

  @JsonProperty("weather")
  private Object weather = null;

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

  public Resort slope(Object slope) {
    this.slope = slope;
    return this;
  }

  /**
   * Get slope
   * @return slope
  */
  @ApiModelProperty(value = "")


  public Object getSlope() {
    return slope;
  }

  public void setSlope(Object slope) {
    this.slope = slope;
  }

  public Resort tempretature(BigDecimal tempretature) {
    this.tempretature = tempretature;
    return this;
  }

  /**
   * Get tempretature
   * @return tempretature
  */
  @ApiModelProperty(value = "")

  public BigDecimal getTempretature() {
    return tempretature;
  }

  public void setTempretature(BigDecimal tempretature) {
    this.tempretature = tempretature;
  }

  public Resort weather(Object weather) {
    this.weather = weather;
    return this;
  }

  /**
   * Get weather
   * @return weather
  */
  @ApiModelProperty(value = "")


  public Object getWeather() {
    return weather;
  }

  public void setWeather(Object weather) {
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
        Objects.equals(this.slope, resort.slope) &&
        Objects.equals(this.tempretature, resort.tempretature) &&
        Objects.equals(this.weather, resort.weather);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, website, slope, tempretature, weather);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resort {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    slope: ").append(toIndentedString(slope)).append("\n");
    sb.append("    tempretature: ").append(toIndentedString(tempretature)).append("\n");
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
}

