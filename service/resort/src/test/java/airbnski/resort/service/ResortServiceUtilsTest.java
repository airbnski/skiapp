package airbnski.resort.service;

import airbnski.resort.client.model.ClientResort;
import airbnski.resort.client.model.Image;
import airbnski.resort.client.model.Media;
import airbnski.resort.client.model.Slope;
import airbnski.resort.generated.model.Resort;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResortServiceUtilsTest {
    @Test
    public void testConcatRegionIds() {
        assertEquals(141, ResortServiceUtils.concatRegionIds().length);
    }

    @Test
    public void testGetSize() {
        assertEquals(141, ResortServiceUtils.getSize());
    }

    @Test
    public void testConvertClient() throws InterruptedException, ExecutionException {

        Media media = new Media();
        media.setOriginal(new Image());

        Slope slope = new Slope();
        slope.setMedia(media);

        ClientResort clientResort = new ClientResort();
        clientResort.setSlope(new Slope[]{slope});
        clientResort.setWebsite("42");
        clientResort.setName("42");
        clientResort.setLatitude(47.37892103064415);
        clientResort.setId(123);
        clientResort.setLongitude(47.37892103064415);
        clientResort.setStatus("Status");
        Resort resort = ResortServiceUtils.convertClient(clientResort);
        assertEquals(resort.getWebsite(), clientResort.getWebsite());
        assertEquals(resort.getName(), clientResort.getName());
        assertEquals(resort.getLatitude(), clientResort.getLatitude());
        assertEquals(resort.getId(), clientResort.getId());
        assertEquals(resort.getLongitude(), clientResort.getLongitude());
        assertEquals(resort.getStatus(), clientResort.getStatus());
    }
}

