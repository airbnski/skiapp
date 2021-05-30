package airbnski.common.client.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractEntityTest {
    @Test
    public void testConstructor() {
        AbstractEntity actualAbstractEntity = new AbstractEntity();
        actualAbstractEntity.setId(1);
        assertEquals(1, actualAbstractEntity.getId().intValue());
    }
}

