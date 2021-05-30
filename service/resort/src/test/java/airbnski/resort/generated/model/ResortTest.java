package airbnski.resort.generated.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResortTest {
    @Test
    public void testEquals() {
        assertFalse((new Resort()).equals("42"));
        assertFalse((new Resort()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1796951359, (new Resort()).hashCode());
    }

    @Test
    public void testIsWithinCoordinates() {
        Resort resort = new Resort();
        resort.latitude(3.141592653589793);
        resort.setLongitude(10.0);
        assertFalse(resort.isWithinCoordinates(10.0, 10.0, 10.0));
        assertEquals(473.847363563481, resort.getDistance().doubleValue());
    }

    @Test
    public void testIsWithinCoordinates2() {
        Resort resort = new Resort();
        resort.latitude(10.0);
        resort.setLongitude(10.0);
        assertTrue(resort.isWithinCoordinates(10.0, 10.0, 10.0));
        assertEquals(5.8987221219522616E-5, resort.getDistance().doubleValue());
    }

    @Test
    public void testIsWithinCoordinates3() {
        Resort resort = new Resort();
        resort.latitude(3.141592653589793);
        resort.setLongitude(10.0);
        assertFalse(resort.isWithinCoordinates(180.0, 10.0, 10.0));
        assertEquals(11296.946760726023, resort.getDistance().doubleValue());
    }

    @Test
    public void testIsWithinCoordinates4() {
        Resort resort = new Resort();
        resort.latitude(3.141592653589793);
        resort.setLongitude(10.0);
        assertFalse(resort.isWithinCoordinates(10.0, 180.0, 10.0));
        assertEquals(12219.147363563481, resort.getDistance().doubleValue());
    }

    @Test
    public void testIsWithinCoordinates5() {
        Resort resort = new Resort();
        resort.latitude(3.141592653589793);
        resort.setLongitude(10.0);
        assertFalse(resort.isWithinCoordinates(10.0, 10.0, null));
        assertEquals(473.847363563481, resort.getDistance().doubleValue());
    }

    @Test
    public void testDistanceFromCenter() {
        Resort resort = new Resort();
        resort.latitude(3.141592653589793);
        resort.setLongitude(3.141592653589793);
        resort.distanceFromCenter(10.0, 10.0);
        assertEquals(667.7153625239331, resort.getDistance().doubleValue());
    }

    @Test
    public void testConstructor() {
        Resort actualResort = new Resort();
        actualResort.distance(10.0);
        actualResort.id(1);
        actualResort.image("Image");
        actualResort.latitude(10.0);
        actualResort.longitude(10.0);
        actualResort.name("Name");
        actualResort.setDistance(10.0);
        actualResort.setId(1);
        actualResort.setImage("Image");
        actualResort.setLatitude(10.0);
        actualResort.setLongitude(10.0);
        actualResort.setName("Name");
        Slope slope = new Slope();
        actualResort.setSlope(slope);
        actualResort.setStatus("Status");
        Weather weather = new Weather();
        actualResort.setWeather(weather);
        actualResort.setWebsite("Website");
        Slope slope1 = new Slope();
        actualResort.slope(slope1);
        actualResort.status("Status");
        Weather weather1 = new Weather();
        actualResort.weather(weather1);
        actualResort.website("Website");
        assertEquals(10.0, actualResort.getDistance().doubleValue());
        assertEquals(1, actualResort.getId().intValue());
        assertEquals("Image", actualResort.getImage());
        assertEquals(10.0, actualResort.getLatitude().doubleValue());
        assertEquals(10.0, actualResort.getLongitude().doubleValue());
        assertEquals("Name", actualResort.getName());
        Slope slope2 = actualResort.getSlope();
        assertSame(slope1, slope2);
        assertEquals(slope, slope2);
        assertEquals("Status", actualResort.getStatus());
        Weather weather2 = actualResort.getWeather();
        assertEquals(weather, weather2);
        assertSame(weather1, weather2);
        assertEquals("Website", actualResort.getWebsite());
        assertEquals(
                "class Resort {\n" + "    id: 1\n" + "    name: Name\n" + "    website: Website\n" + "    status: Status\n"
                        + "    longitude: 10.0\n" + "    latitude: 10.0\n" + "    distance: 10.0\n" + "    image: Image\n"
                        + "    slope: class Slope {\n" + "        easyDistance: null\n" + "        mediumDistance: null\n"
                        + "        hardDistance: null\n" + "    }\n" + "    weather: class Weather {\n"
                        + "        temperature: null\n" + "        outlook: null\n" + "    }\n" + "}",
                actualResort.toString());
    }
}

