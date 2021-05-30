package airbnski.resort.generated.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SlopeTest {
    @Test
    public void testEquals() {
        assertFalse((new Slope()).equals("42"));
        assertFalse((new Slope()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(29791, (new Slope()).hashCode());
    }

    @Test
    public void testConstructor() {
        Slope actualSlope = new Slope();
        actualSlope.easyDistance(1);
        actualSlope.hardDistance(1);
        actualSlope.mediumDistance(1);
        actualSlope.setEasyDistance(1);
        actualSlope.setHardDistance(1);
        actualSlope.setMediumDistance(1);
        assertEquals(1, actualSlope.getEasyDistance().intValue());
        assertEquals(1, actualSlope.getHardDistance().intValue());
        assertEquals(1, actualSlope.getMediumDistance().intValue());
        assertEquals("class Slope {\n    easyDistance: 1\n    mediumDistance: 1\n    hardDistance: 1\n}",
                actualSlope.toString());
    }
}

