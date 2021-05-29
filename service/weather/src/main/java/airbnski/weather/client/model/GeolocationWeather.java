package airbnski.weather.client.model;
import airbnski.common.client.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GeolocationWeather extends AbstractEntity {
    public GeolocationWeather() { }

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("main")
    private Temperature temperature;

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}





