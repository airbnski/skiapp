package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientResortTest {
    @Test
    public void testConstructor() {
        ClientResort actualClientResort = new ClientResort();
        actualClientResort.setLatitude(10.0);
        actualClientResort.setLongitude(10.0);
        actualClientResort.setName("Name");
        actualClientResort.setOpeningYear(1L);
        actualClientResort.setSlope(new Slope[]{new Slope()});
        actualClientResort.setStatus("Status");
        actualClientResort.setTags(new Tag[]{new Tag()});
        actualClientResort.setWebsite("Website");
        assertEquals(10.0, actualClientResort.getLatitude().doubleValue());
        assertEquals(10.0, actualClientResort.getLongitude().doubleValue());
        assertEquals("Name", actualClientResort.getName());
        assertEquals(1L, actualClientResort.getOpeningYear().longValue());
        assertEquals("Status", actualClientResort.getStatus());
        assertEquals("Website", actualClientResort.getWebsite());
    }
}

