package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegionTest {
    @Test
    public void testConstructor() {
        Region actualRegion = new Region();
        actualRegion.setId(123L);
        actualRegion.setName("Name");
        assertEquals(123L, actualRegion.getId().longValue());
        assertEquals("Name", actualRegion.getName());
    }
}

