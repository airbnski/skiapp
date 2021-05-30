package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {
    @Test
    public void testConstructor() {
        Image actualImage = new Image();
        actualImage.setHeight(1L);
        actualImage.setSize(3L);
        actualImage.setUrl("https://example.org/example");
        actualImage.setWidth(1L);
        assertEquals(1L, actualImage.getHeight().longValue());
        assertEquals(3L, actualImage.getSize().longValue());
        assertEquals("https://example.org/example", actualImage.getUrl());
        assertEquals(1L, actualImage.getWidth().longValue());
    }
}

