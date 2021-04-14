package airbnski.resort.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Slope
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-04-14T14:41:49.663320+02:00[Europe/Zurich]")

public class Slope   {
  @JsonProperty("easyDistance")
  private Integer easyDistance;

  @JsonProperty("mediumDistance")
  private Integer mediumDistance;

  @JsonProperty("hardDistance")
  private Integer hardDistance;

  public Slope easyDistance(Integer easyDistance) {
    this.easyDistance = easyDistance;
    return this;
  }

  /**
   * Get easyDistance
   * @return easyDistance
  */
  @ApiModelProperty(value = "")


  public Integer getEasyDistance() {
    return easyDistance;
  }

  public void setEasyDistance(Integer easyDistance) {
    this.easyDistance = easyDistance;
  }

  public Slope mediumDistance(Integer mediumDistance) {
    this.mediumDistance = mediumDistance;
    return this;
  }

  /**
   * Get mediumDistance
   * @return mediumDistance
  */
  @ApiModelProperty(value = "")


  public Integer getMediumDistance() {
    return mediumDistance;
  }

  public void setMediumDistance(Integer mediumDistance) {
    this.mediumDistance = mediumDistance;
  }

  public Slope hardDistance(Integer hardDistance) {
    this.hardDistance = hardDistance;
    return this;
  }

  /**
   * Get hardDistance
   * @return hardDistance
  */
  @ApiModelProperty(value = "")


  public Integer getHardDistance() {
    return hardDistance;
  }

  public void setHardDistance(Integer hardDistance) {
    this.hardDistance = hardDistance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Slope slope = (Slope) o;
    return Objects.equals(this.easyDistance, slope.easyDistance) &&
        Objects.equals(this.mediumDistance, slope.mediumDistance) &&
        Objects.equals(this.hardDistance, slope.hardDistance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(easyDistance, mediumDistance, hardDistance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Slope {\n");
    
    sb.append("    easyDistance: ").append(toIndentedString(easyDistance)).append("\n");
    sb.append("    mediumDistance: ").append(toIndentedString(mediumDistance)).append("\n");
    sb.append("    hardDistance: ").append(toIndentedString(hardDistance)).append("\n");
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

