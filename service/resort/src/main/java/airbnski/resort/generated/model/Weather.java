package airbnski.resort.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Weather
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-14T14:41:49.663320+02:00[Europe/Zurich]")

public class Weather   {
  @JsonProperty("temperature")
  private Double temperature;

  @JsonProperty("outlook")
  private String outlook;

  public Weather temperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
  */
  @ApiModelProperty(value = "")


  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Weather outlook(String outlook) {
    this.outlook = outlook;
    return this;
  }

  /**
   * Get outlook
   * @return outlook
  */
  @ApiModelProperty(value = "")


  public String getOutlook() {
    return outlook;
  }

  public void setOutlook(String outlook) {
    this.outlook = outlook;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Weather weather = (Weather) o;
    return Objects.equals(this.temperature, weather.temperature) &&
        Objects.equals(this.outlook, weather.outlook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(temperature, outlook);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Weather {\n");
    
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    outlook: ").append(toIndentedString(outlook)).append("\n");
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

