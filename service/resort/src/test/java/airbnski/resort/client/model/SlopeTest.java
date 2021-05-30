package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SlopeTest {
    @Test
    public void testConstructor() {
        Slope actualSlope = new Slope();
        actualSlope.setId(123L);
        Media media = new Media();
        actualSlope.setMedia(media);
        actualSlope.setName("Name");
        assertEquals(123L, actualSlope.getId().longValue());
        assertSame(media, actualSlope.getMedia());
        assertEquals("Name", actualSlope.getName());
    }
}

