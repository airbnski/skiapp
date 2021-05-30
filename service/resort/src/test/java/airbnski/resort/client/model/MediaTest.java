package airbnski.resort.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class MediaTest {
    @Test
    public void testConstructor() {
        Media actualMedia = new Media();
        Image image = new Image();
        actualMedia.setImage(image);
        Image image1 = new Image();
        actualMedia.setOriginal(image1);
        actualMedia.setSizes(new Image[]{new Image()});
        assertSame(image, actualMedia.getImage());
        assertSame(image1, actualMedia.getOriginal());
    }
}

