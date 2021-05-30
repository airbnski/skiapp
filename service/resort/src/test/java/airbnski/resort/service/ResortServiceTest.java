package airbnski.resort.service;

import airbnski.resort.generated.model.Resort;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResortServiceTest {

    @Test
    public void testGetResort() throws InterruptedException, ExecutionException {
        assertEquals(new ResortService().getResort(1002).getId(), 1002);
    }

    @Test
    public void testGetAllResorts() {
        assertEquals(((Resort[]) new ResortService().getAllResorts()).length, 141);
    }

    @Test
    public void testGetResortByCoordinates() {
        assertEquals(((Resort[]) new ResortService().getResortByCoordinates(8.9969619750977, 47.286132373338, 5d))[0].getId(), 3828);
    }

}

